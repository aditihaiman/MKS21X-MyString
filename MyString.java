public class MyString implements CharSequence, Comparable<CharSequence> {
  public static void main(String[] args) {
    MyString str = new MyString("hello");
    System.out.println(str.charAt(3));
    System.out.println(str.charAt(-1));

  }
  private char[] charArray;

  public MyString(CharSequence s) {
    charArray = new char[s.length()];
    for (int x = 0; x < s.length(); x++) { //builds charArray with each element of CharSequence
      charArray[x] = s.charAt(x);
    }
  }

  public char charAt(int index) {
    if (index < 0 || index >= this.length()) {
      throw new IndexOutOfBoundsException();
    }
    return charArray[index];
  }

  public int length() {
    return charArray.length;
  }

  public CharSequence subSequence(int start, int end) { //subsequence inclusive of start, exclusive of end
    if (start < 0 || end < 0 || start >= this.length() || end > this.length()){
      throw new IndexOutOfBoundsException();
    }
    String output = "";
    for (int x = start; x < end; x++){ //adds each element to output
      output += this.charArray[x];
    }
    return output;
  }

  public String toString() {
    String output = "";
    for (int x = 0; x < charArray.length; x++) { //combines array into one string
      output += charArray[x];
    }
    return output;
  }

  public int compareTo(CharSequence obj) {
    if (obj.equals(null)) throw new NullPointerException();
    return 0;
  }

}
