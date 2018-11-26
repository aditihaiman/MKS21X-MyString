public class MyString implements CharSequence, Comparable<CharSequence> {
  public static void main(String[] args) {
    MyString str = new MyString("hello");
    MyString str1 = new MyString("world");
    MyString str2 = new MyString("fish");

    System.out.println(str.charAt(4));
    System.out.println("hello".charAt(4));
    System.out.println();
    System.out.println(str2.length());
    System.out.println("fish".length());
    System.out.println();
    System.out.println(str2.subSequence(0, 2));
    System.out.println("fish".substring(0, 2));
    System.out.println();
    System.out.println(str.toString());
    System.out.println("hello".toString());
    System.out.println();
    System.out.println(str.compareTo("worlds"));
    System.out.println("hello".compareTo("worlds"));
    System.out.println();
    System.out.println(str1.compareTo("worl"));
    System.out.println("world".compareTo("worl"));
    System.out.println();
    System.out.println(str1.compareTo("world"));
    System.out.println("world".compareTo("world"));
    System.out.println();
    System.out.println(str2.compareTo("TUNAFISH"));
    System.out.println("fish".compareTo("TUNAFISH"));

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
    boolean check = true;
    if (obj.equals(null)) throw new NullPointerException();
    for (int x = 0; check && x < obj.length() && x < this.length(); x++) { //checks equality of chars up to the length of shorter CharSequence
      if (this.charAt(x)== obj.charAt(x)) output = 0;
      else {
        //System.out.println(this.charAt(x) + " ; " + obj.charAt(x));
        output = this.charAt(x) - obj.charAt(x);
        check = false; //if the code reaches this point, it should exit the loop
      }
    }
    if (output == 0 && this.length() != obj.length()) { //checks if the two CharSequences have different lengths
      output = this.length() - obj.length();
    }
    return output;
  }

}
