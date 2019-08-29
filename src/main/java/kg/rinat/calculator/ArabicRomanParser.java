package kg.rinat.calculator;

public class ArabicRomanParser {
    public static final String[] rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};
    public static final int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int romeToArab(String romeNumber) {

        StringBuffer romanNumber = new StringBuffer(romeNumber);
        int arabNumber = 0, i = 0;
        while (true) {
            do {
                if (rome[i].length() <= romanNumber.length()) {
                    // Выделяем из строки подстроку и сравниваем со
                    // значением из массива arab
                    if (rome[i].equals(romanNumber.substring(0,
                            rome[i].length()))) {
                        // После чего прибавляем число соответствующее
                        // индексу элемента римской цифры из массива arab
                        arabNumber += arab[i];
                        // и удаляем из строки римскую цифру
                        romanNumber.delete(0, rome[i].length());
                        if (romanNumber.length() == 0)
                            return arabNumber;
                    } else
                        break;
                } else
                    break;
            } while (romanNumber.length() != 0);
            i++;
        }
    }

    public String arabicToRome(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < rome.length)) {
            int currentSymbol = arab[i];
            if (currentSymbol <= number) {
                sb.append(rome[i]);
                number -= arab[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}