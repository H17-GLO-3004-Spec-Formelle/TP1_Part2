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
            Thread.sleep(0);//2000);
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
        FUEL("Fuel"),
        GATE("Gate"),
        RUNWAY("Runway"),
        TECHNIQUE("Technique");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}

