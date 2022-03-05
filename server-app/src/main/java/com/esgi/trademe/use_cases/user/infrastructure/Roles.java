package com.esgi.trademe.use_cases.user.infrastructure;

public enum Roles {
        PROVIDER("PROVIDER"),
        WORKER("WORKER"),
        ADMIN("ADMIN");

        private final String displayName;

        Roles(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
}

