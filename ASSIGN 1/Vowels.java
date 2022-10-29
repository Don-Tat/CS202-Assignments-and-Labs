public class Vowels {
    /*
     * 2. Write code that accomplishes the following tasks:
     * Consider two bags that can hold strings.
     * One bag is named letters and contains several one-letter strings.
     * The other bag is empty and is named vowels.
     * One at a time, remove a string from letters.
     * If the string contains a vowel, place it into the bag vowels; otherwise,
     * discard the string.
     * After you have checked all of the strings in letters, report the number of
     * vowels in the bag vowels and the number of times each vowel appears in the
     * bag.
     */
    public static void main(String[] args) {
        BagInterface<String> letters = new ArrayBag<String>();
        BagInterface<String> vowels = new ArrayBag<String>();
        String[] letterItems = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        for (int index = 0; index < letterItems.length; index++) {
            letters.add(letterItems[index]);
        }
        while (!letters.isEmpty()) {
            String letter = letters.remove();
            if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o")
                    || letter.equals("u")) {
                vowels.add(letter);
            }
        }
        System.out.println("The number of vowels in the bag vowels is " + vowels.getCurrentSize());
        System.out.println("The number of times that a occurred in the bag vowels is " + vowels.getFrequencyOf("a"));
        System.out.println("The number of times that e occurred in the bag vowels is " + vowels.getFrequencyOf("e"));
        System.out.println("The number of times that i occurred in the bag vowels is " + vowels.getFrequencyOf("i"));
        System.out.println("The number of times that o occurred in the bag vowels is " + vowels.getFrequencyOf("o"));
        System.out.println("The number of times that u occurred in the bag vowels is " + vowels.getFrequencyOf("u"));

        BagInterface<String> letters2 = new ArrayBag<String>();
        String[] letterItems2 = { "soup", "carrot", "chicken", "chicken", "noodles", "noodles", "noodles", "soup",
                "soup", "soup" };
        for (int index = 0; index < letterItems2.length; index++) {
            letters2.add(letterItems2[index]);
        }
        // test equals method

    }
}
