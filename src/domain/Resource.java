package domain;

import exception.ResourceNotAvailableException;

public class Resource {

    private final Type type;
    private final int number;

    private Boolean isAvailable = true;

    Resource(Type type, int number) {
        this.type = type;
        this.number = number;

        isAvailable = true;
    }

    Type getType() {
        return type;
    }

    synchronized boolean isAvailable() {
        return isAvailable;
    }

    void acquire() throws ResourceNotAvailableException {
        synchronized (isAvailable) {
            if (!isAvailable) {
                throw new ResourceNotAvailableException(this);
            }
            isAvailable = false;
        }
    }

    void use() {
        try {
            Thread.sleep(type.delay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt(); //Should happen only when killing the execution
        }
    }

    void release() {
        synchronized (isAvailable) {
            isAvailable = true;
        }
    }


    @Override
    public String toString() {
        return this.type.name() + String.valueOf(number);
    }

    public enum Type {
        AUTHORITY("Authority", 0),
        FUEL("Fuel", 1000),
        GATE("Gate", 2000),
        RUNWAY("Runway", 500),
        TECHNIQUE("Technique", 2000);

        private final String name;
        private final int delay; //In milliseconds

        Type(String name, int delay) {
            this.name = name;
            this.delay = delay;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}

