package test_data;

public enum EmailType {
    STANDARD {
        @Override
        public String generate() {
            return "user@example.com";
        }
    },
    WITH_NUMBERS {
        @Override
        public String generate() {
            return "user123@test.com";
        }
    },
    WITH_DOTS {
        @Override
        public String generate() {
            return "user.name@domain.com";
        }
    };


    public abstract String generate();
}
