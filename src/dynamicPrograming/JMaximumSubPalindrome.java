package dynamicPrograming;

public class JMaximumSubPalindrome {
    public static void main(String[] args) {
        String row = "HTEOLFEOLEH";
//        String row = "HELOLEHdf";
//        String row = "babad";
        String subPalindrome = "";



        for (int i = 0; i < row.length(); i++) {
            int left = i;
            int right = i;

            while (right < row.length() - 1 && row.charAt(left) == row.charAt(right + 1)) {
                right++;
            }

            while (left > 0 && right < row.length() - 1 &&
                    row.charAt(left - 1) == row.charAt(right + 1)) {
                left--;
                right++;
            }
            if (right - left + 1 > subPalindrome.length()) {
                subPalindrome = row.substring(left, right + 1);
            }

        }
        System.out.println(subPalindrome);
    }
}
// H E L  OLEH
// HTEOLFEOLEH
//        |
//        |

