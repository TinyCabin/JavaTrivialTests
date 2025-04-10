package zadanie_2;

public class Code {
    public String convert(String s, int numRows) throws InvalidConversionException, EmptyStringException{
        if (numRows <= 0) {
            throw new InvalidConversionException("Liczba wierszy musi być wieksza niz 0.");
        }

        if (s == null || s.isEmpty()) {
            throw new EmptyStringException("Podany łańcuch znaków jest pusty.");
        }

        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0;
        int direction = 1;

        for (char c : s.toCharArray()) {
            rows[index].append(c);
            index += direction;
            if (index == 0 || index == numRows - 1) {
                direction = -direction;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Code solution = new Code();

        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        try {
            System.out.println("Przykład 1:");
            System.out.println("s = \"" + s1 + "\", numRows = " + numRows1);
            System.out.println("\"" + solution.convert(s1, numRows1) + "\"");
        } catch (InvalidConversionException | EmptyStringException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        try {
            System.out.println("\nPrzykład 2:");
            System.out.println("s = \"" + s2 + "\", numRows = " + numRows2);
            System.out.println("\"" + solution.convert(s2, numRows2) + "\"");
        } catch (InvalidConversionException | EmptyStringException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}

class InvalidConversionException extends Exception {
    public InvalidConversionException(String message) {
        super(message);
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}