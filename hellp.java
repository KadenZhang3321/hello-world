public class hellp {
    public static String convert(String mStr, int base) {
        // mStr is decimal positive number string, base is target base
        if (base < 2 || base > 36) return "";
        // handle integer and fractional parts
        String[] parts = mStr.split("\\.");
        long integerPart = Long.parseLong(parts[0]);
        String fracPart = parts.length > 1 ? parts[1] : "";
        StringBuilder result = new StringBuilder();
        // convert integer part
        if (integerPart == 0) {
            result.append("0");
        } else {
            while (integerPart > 0) {
                int digit = (int)(integerPart % base);
                result.append(digit < 10 ? (char)('0'+digit) : (char)('A'+digit-10));
                integerPart /= base;
            }
            result.reverse();
        }
        result.append('.');
        // convert fractional part
        double frac = 0.0;
        if (!fracPart.isEmpty()) {
            frac = Double.parseDouble("0." + fracPart);
        }
        for (int i = 0; i < 10; i++) {
            frac *= base;
            int digit = (int)frac;
            result.append(digit < 10 ? (char)('0'+digit) : (char)('A'+digit-10));
            frac -= digit;
        }
        return result.toString();
    }

    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            if (parts.length < 2) continue;
            String m = parts[0];
            int n = Integer.parseInt(parts[1]);
            if (m.equals("0") && n == 0) {
                break;
            }
            String output = convert(m, n);
            System.out.println(output);
        }
        //some change
        //new change
    }
}
