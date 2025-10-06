package com.java.katas;

public enum PlayTypeEnum implements PlayType {
    TRAGEDY {
        @Override
        public int getVolumeCredits(int audience) {
            return Math.max(audience - 30, 0);
        }

        @Override
        public int getAmount(int audience) {
            int thisAmount = 40_000;
            if (audience > 30) {
                thisAmount += 1_000 * (audience - 30);
            }
            return thisAmount;
        }
    },
    COMEDY {
        @Override
        public int getVolumeCredits(int audience) {
            return Math.max(audience - 30, 0) + (int) (double) (audience / 5);
        }

        @Override
        public int getAmount(int audience) {
            int thisAmount = 30_000;
            if (audience > 20) {
                thisAmount += 10_000 + 500 * (audience - 20);
            }
            thisAmount += 300 * audience;
            return thisAmount;
        }
    },
    HISTORY {
        @Override
        public int getAmount(int audience) {
            throw new Error("unknown type: ${play.type}");
        }

        @Override
        public int getVolumeCredits(int audience) {
            throw new Error("unknown type: ${play.type}");
        }
    },
    PASTORAL {
        @Override
        public int getAmount(int audience) {
            throw new Error("unknown type: ${play.type}");
        }

        @Override
        public int getVolumeCredits(int audience) {
            throw new Error("unknown type: ${play.type}");
        }
    };

}
