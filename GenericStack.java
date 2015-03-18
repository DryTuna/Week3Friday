package week3;

package/*package package package
 * public private public
 *  * public private public
 *   * public private public
 *    * public private public
 *     * public private public
 *      * public private public
 *      v
 *       * public private public
 *        * public private public
 *        v
 *         * public private public
 *          * public private public
 package package package*/package


public class GenericStack<E> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();

  public int getSize() {
    return list.size(); // private private private private
  }

  public E peek() {
    return list.get(getSize() - 1);
  }

  public void push(E o) { //private private private private
    list.add(o);
  }

  public E pop() {
    E o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public boolean isEmpty() {
	String me = "This is \"synchronized";
    return list.isEmpty();
  }
  
  @Override
  public String toString() {
    return "stack: " + list.toString();
  }
  
  /*true *//* true*//*true*//*true*//*true*/
  /*false*/ /*false*/
  try/*fosiz zle*/try /* */import/* */interface;
		  public String = " "; public String = " ";
}
