public class LinkedLizt {

    Link first;     // firstLink
    Link last;      // lastLink

    public LinkedLizt(){
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        if (first == null && last == null) return true;
        return false;
    }


    public void addFirstLinkIntoEmptyList(int value) {
        first = new Link();
        first.prev = null;
        first.next = null;
        first.value = value;
        last = first;
    }

    // insertion into proper position
    public void insert(int value) {

        // if LinkedLizt is empty
        if (this.isEmpty()) {
            addFirstLinkIntoEmptyList(value);

        } else {    // if there are already elements in LinkedLizt
            Link newLink = new Link();
            newLink.value = value;

            Link current = last;
            // if new element is larger than last element (or equal) , insert at last position
            if (newLink.value >= last.value) {
                last.next = newLink;
                newLink.prev = last;
                last = newLink;
            } else  if (newLink.value <= first.value) {   // if new element is smaller than first element (or equal), insert at first position
                newLink.next = first;
                first.prev = newLink;
                first = newLink;
            } else {
                // if goes in the middle, compare with last link and backwards to find proper place and insert into it
                while (newLink.value < current.value) {
                    current = current.prev;
                }
                newLink.next = current.next;
                newLink.prev = current;
                current.next.prev = newLink;
                current.next = newLink;
            }
        }
    }

    // add to end of the list // *** however, this will spoil insert function, since list will not be sorted anymore
    public void add(int value) {

        // if LinkedLizt is empty
        if (this.isEmpty()) {
            addFirstLinkIntoEmptyList(value);

        } else {    // if there are already elements in LinkedLizt
            Link newLink = new Link();
            last.next = newLink;
            newLink.prev = last;
            last = newLink;
            newLink.value = value;

        }

    }

    public void removeFirst() {

        // if only one element in the list
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            first.next.prev = null;
            first = first.next;
     }
   }

    public void print() {

        Link current = first;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println();


    }

}


class Link {

    Link next;
    Link prev;

    int value;

}
