public class MyString implements CharSequence, Comparable<CharSequence> {

  private char[] charArray;

  public MyString(CharSequence s) {
    charArray = new char[s.length()];
    for (int x = 0; x < s.length(); x++) {
      charArray[x] = s.charAt(x);
    }
  }

  public char charAt(int index) {
    return charArray[index];
  }

  public int length() {
    return charArray.length;
  }

  public CharSequence subSequence(int start, int end) {
    CharSequence output = new MyString(this);
    for (int x = start; x < end; x++){

    }
  }

  public String toString() {
    String output = "";
    for (int x = 0; x < charArray.length; x++) {
      output += charArray[x];
    }
    return output;
  }

}
