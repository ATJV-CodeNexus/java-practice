public class MusicShop {

    public static void main(String[] args) {

        Instrument[] instruments = new Instrument[3];

        instruments[0] = new Guitar("Fender Stratocaster", 2020, 6, "electric");
        instruments[1] = new Piano("Steinway", 2015, true);
        instruments[2] = new Guitar("Martin", 2018, 12, "acoustic");

        System.out.println("===== PLAYING INSTRUMENTS =====");

        for (Instrument instrument : instruments) {
            System.out.println(instrument.play());
            System.out.println(instrument.getInstrumentDetails());
        }

        System.out.println("===== MAINTAINING INSTRUMENTS =====");

        for (Instrument instrument : instruments) {

            System.out.println("Working with " + instrument.getName());

            if (instrument instanceof Tunable) {
                Tunable tunableInstrument = (Tunable) instrument;
                System.out.println(tunableInstrument.tune());
                System.out.println(tunableInstrument.adjustPitch(true));
            }

            if (instrument instanceof Maintainable) {
                Maintainable maintainableInstrument = (Maintainable) instrument;
                System.out.println(maintainableInstrument.clean());
                System.out.println(maintainableInstrument.inspect());
            }
        }
    }
}
