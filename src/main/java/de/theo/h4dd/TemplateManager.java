package de.theo.h4dd;

import java.util.ArrayList;
import java.util.List;

public class TemplateManager {

    private BattalionsContainer battalionsContainer = new BattalionsContainer();


    public void addBattalion(int line, BattalionType type) {
        battalionsContainer.addBattalion(line, type);
    }

    public void removeBattalion(int line, int battalionIndex) {
        battalionsContainer.removeBattalion(line, battalionIndex);
    }


    private class BattalionsContainer {

        private List<BattalionColumn> columns;

        public BattalionsContainer() {
            columns = new ArrayList<BattalionColumn>(5);
            columns.add(new BattalionColumn());
            columns.add(new BattalionColumn());
            columns.add(new BattalionColumn());
            columns.add(new BattalionColumn());
            columns.add(new BattalionColumn());
        }

        public void addBattalion(int line, BattalionType type) {
            if (line < 0 || line > 4) {
                throw new IllegalArgumentException("Valid values for Battalion lines are 0 to 4, but was " + line);
            }
            columns.get(line).addBattalion(type);
        }

        public void removeBattalion(int line, int battalionIndex) {
            if (line < 0 || line > 4) {
                throw new IllegalArgumentException("Valid values for Battalion lines are 0 to 4, but was " + line);
            }
            columns.get(line).removeBattalion(battalionIndex);
        }


    }

    private class BattalionColumn {
        List<BattalionType> battalions;

        public BattalionColumn() {
            battalions = new ArrayList<BattalionType>(5);
        }

        public void addBattalion(BattalionType type) {
            if (battalions.size() >= 5) {
                throw new IllegalArgumentException("Cannot add more than 5 battalions to line");
            }
            battalions.add(type);
        }

        public void removeBattalion(int index) {
            battalions.remove(index);
        }
    }
}
