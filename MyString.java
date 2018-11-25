public class MyString implements CharSequence, Comparable<CharSequence> {
  public static void main(String[] args) {
    MyString str = new MyString("hello");
    MyString str1 = new MyString("world");
    MyString str2 = new MyString("fish");
    
    System.out.println(str.charAt(4));
    System.out.println("hello".charAt(4));
    System.out.println();
    System.out.println(str.compareTo("worlds"));
    System.out.println("hello".compareTo("worlds"));

  }
  private char[] charArray;

//—————————————————————————————————CONSTRUCTORS—————————————————————————————————————————//

  public MyString(CharSequence s) {
    charArray = new char[s.length()];
    for (int x = 0; x < s.length(); x++) { //builds charArray with each element of CharSequence
      charArray[x] = s.charAt(x);
    }
  }

//––––––––––––––––––––––––––––––––––METHODS––––––––––––––––––––––––––––––––––––––––––––//

  public char charAt(int index) {
    if (index < 0 || index >= this.length()) {
      throw new IndexOutOfBoundsException();
    }
    return charArray[index];
  }

  public int length() {
    return charArray.length;
  }

  public CharSequence subSequence(int start, int end) { //returns subsequence inclusive of start, exclusive of end
    if (start < 0 || end < 0 || start >= this.length() || end > this.length()){
      throw new IndexOutOfBoundsException();
    }
    String output = "";
    for (int x = start; x < end; x++){ //adds each element to output String
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
    int output = 0;
    if (obj.equals(null)) throw new NullPointerException();
    for (int x = 0; x < obj.length() && x < this.length(); x++) { //checks equality of chars up to the length of shorter CharSequence
      if (this.charAt(x)== obj.charAt(x)) output = 0;
      else {
        if ((this.charAt(x)) > (obj.charAt(x))) output = 1;
        output = -1;
      }
    }
    if (output == 0 && this.length() > obj.length()) output = 1; //checks if the two CharSequences have different lengths
    if (output == 0 && this.length() < obj.length()) output = -1;
    return output;
  }

}
