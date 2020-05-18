package com.example.messagingstompwebsocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockInfo {

    public static enum Trend {
        UP("up"),
        DOWN("down"),
        CONSTANT("equal"),
        NONE("none");
        private final String text;

        Trend(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private String symbol;
    private String price;
    private String trend;

}
