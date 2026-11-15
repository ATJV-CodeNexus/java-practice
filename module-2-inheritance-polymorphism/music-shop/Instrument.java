abstract class Instrument {

    private String name;
    protected int year;

    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }

    abstract String play();

    public String getInstrumentDetails() {
        return "name: " + this.name + " year: " + this.year;
    }

    public String getName() {
        return this.name;
    }
}

interface Tunable {
    String tune();

    String adjustPitch(boolean up);
}

interface Maintainable {
    String clean();

    String inspect();
}

class StringedInstrument extends Instrument {

    private int numberOfStrings;

    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    String play() {
        return "playing the stringed instrument";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Strings: " + numberOfStrings;
    }

    public int getNumberOfStrings() {
        return this.numberOfStrings;
    }
}

class Guitar extends StringedInstrument implements Tunable, Maintainable {

    private String guitarType;

    public Guitar(String name, int year, int numberOfStrings, String guitarType) {
        super(name, year, numberOfStrings);
        this.guitarType = guitarType;
    }

    @Override
    String play() {
        return "Playing the " + guitarType + " guitar with " + getNumberOfStrings() + " strings";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + guitarType;
    }

    @Override
    public String tune() {
        return "Tuning the " + guitarType + " guitar";
    }

    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the guitar" : "Decreasing pitch of the guitar";
    }

    @Override
    public String clean() {
        return "Cleaning the " + guitarType + " guitar";
    }

    @Override
    public String inspect() {
        return "Inspecting the " + guitarType + " guitar from " + year;
    }
}

class Piano extends Instrument implements Tunable, Maintainable {

    private boolean isGrand;

    public Piano(String name, int year, boolean isGrand) {
        super(name, year);
        this.isGrand = isGrand;
    }

    @Override
    public String play() {
        return "Playing the " + (isGrand ? "grand" : "upright") + " piano";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Type: " + (isGrand ? "Grand" : "Upright");
    }

    // Tunable interface
    @Override
    public String tune() {
        return "Tuning the piano";
    }

    @Override
    public String adjustPitch(boolean up) {
        return up ? "Increasing pitch of the piano" : "Decreasing pitch of the piano";
    }

    // Maintainable interface
    @Override
    public String clean() {
        return "Cleaning the piano keys and interior";
    }

    @Override
    public String inspect() {
        return "Inspecting the " + (isGrand ? "grand" : "upright") + " piano from " + year;
    }
}
