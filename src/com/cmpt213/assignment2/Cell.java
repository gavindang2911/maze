package com.cmpt213.assignment2;

import java.util.HashMap;

public class Cell {

        private final int xIndex;
        private final int yIndex;
        private final String cellType;

        private final HashMap<String, Integer> directions = new HashMap<>();



        public Cell (int xIndex, int yIndex, String cellType) {
            this.xIndex = xIndex;
            this.yIndex = yIndex;
            this.cellType = cellType;
            this.directions.put("U", 0);
            this.directions.put("D", 0);
            this.directions.put("R", 0);
            this.directions.put("L", 0);

        }

        public int getXIndex() {
            return xIndex;
        }
        public int getYIndex() {
            return yIndex;
        }
        public HashMap<String, Integer> getDirections() {
            return directions;
        }

        public void updateDirection(String type) {
            switch (type) {
                case "u" -> directions.put("U", directions.get("U") + 1);
                case "d" -> directions.put("D", directions.get("D") + 1);
                case "r" -> directions.put("R", directions.get("R") + 1);
                default -> directions.put("L", directions.get("L") + 1);
            }
        }

        public String getCellType() {
            return cellType;
        }



}
