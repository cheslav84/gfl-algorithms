package dynamicPrograming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTrimARow {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String row = reader.readLine().strip();

//        String row = "abacdeec";

//        String row = "abbcddka";
//        String row = "ABBA";
//        String row = "ackac";
//        String row = "acka";
        String row = "abcde";

        int counter = 0;

        for (int k = 0; k < row.length(); k++) {
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
                int length = right - left + 1;
                if (length > subPalindrome.length()) {
                    subPalindrome = row.substring(left, right + 1);
                }

            }

            if (subPalindrome.length() % 2 != 0 && subPalindrome.length() > 1) {
              counter++;
            }

            if (subPalindrome.length() > 1) {
                row = row.replaceAll(subPalindrome, "");
            } else if(subPalindrome.length() == 1) {
                int firstIdx = 0;
                int secondIdx = 0;

                outer:
                for (int j = 0; j < row.length(); j++) {
                    for (int m = j + 1; m < row.length(); m++) {
                        if (row.charAt(j) == row.charAt(m)) {
                            firstIdx = j;
                            secondIdx = m;
                            break outer;
                        }
                    }
                }

                if (firstIdx != secondIdx) {
                    String toDelete = row.substring(firstIdx + 1, secondIdx);
                    row = row.replaceAll(toDelete, "");
                    counter += secondIdx - firstIdx - 1;
                } else {
                    counter += row.length();
                    row = "";
                }

            }
            System.out.println(subPalindrome);



        }
//        System.out.println(subPalindrome);
        System.out.println(counter);
//        System.out.println(counter + row.length());
        System.out.println(row);
    }

}
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String row = reader.readLine();
//        String row = "abacdeec";
//        String row = "cdeec";

//        int counter = 0;
//
//        StringBuilder subString = new StringBuilder(row);

//        System.out.println(subString);
//        subString.delete(1, 8);
//        System.out.println(subString);


//            for (int i = 0; i < subString.length() - 1; i++) {
//
//                for (int j = 0; j < subString.length() - 1; j++) {
//                    j = deleteBystanders(subString, j);
//
//                    if (subString.length() > j + i + 1 && subString.charAt(j) == subString.charAt(j + i + 1)) {
//                            subString.delete(j + 1, j + i + 2);
//                            counter += j + i;
//                        }
//
//                }

//                while (subString.length() >= 1) {
//                    if (subString.length() > 2 && subString.charAt(j) == subString.charAt(j + 1)) {
//                        subString.delete(j, j + 2);
//                    }
//                    if (subString.length() > j + i + 2 && subString.charAt(j) == subString.charAt(j + i + 2)) {
//                        subString.delete(j + 1, j + i + 2);
//                        counter += j + i + 1;
//                    }
//
//                }

//                for (int j = 0; j < subString.length() - 1; j++) {
//                    if (subString.length() > 2 && subString.charAt(j) == subString.charAt(j + 1)) {
//                        subString.delete(j, j + 2);
//                    }
//                    if (subString.length() > j + i + 2 && subString.charAt(j) == subString.charAt(j + i + 2)) {
//                        subString.delete(j + 1, j + i + 2);
//                        counter += j + i + 1;
//                    }
//
//                }
//            }


//        System.out.println(counter);

//    }

//    private static int deleteBystanders(StringBuilder subString, int i) {
//        while (subString.length() > 1 && subString.charAt(i) == subString.charAt(i + 1)) {
//            subString.delete(i, i + 2);
//            i--;
//        }
//        return i;
//    }

// 1
//  abefeaecdeec
//  |
//  |


//}

// 1
//  abacdeec
//  |
//   |

// 2
//  ceec
//   |
//   |

// i == step;

// if (subString.charAt(j) == subString.charAt(j + 1) && subString.length() > 2) subString.delete(charAt(j - 1), charAt(i))
// if (subString.charAt(j) == subString.charAt(j + 2)) subString.delete(charAt(j + 1))


//  abefeaecdeec
// todo знайти найдовший поліндром і видалити його,