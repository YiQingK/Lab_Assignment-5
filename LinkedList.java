public class LinkedList<E> 
{
	private Node<E> head;
	private int size;

	public LinkedList()
	{
		head = null;
		size = 0;
	}

	public void add (E item)
	{
		if (head == null)
		{
			head = new Node<E>(item);
			size++;
		}
		Node<E> current = head;
		for (int i =0; i<size;i++)
		{
			current = current.next;
		}
		Node<E> node = new Node<E>(item);
		current.next = node;
		size++;
	}

	public void add (E item, int position) throws Exception
	{
		if (position >= size || position < 0)
		{
			throw new Exception("Invalid postion.");
		}
		if (position == 0)
		{
			Node<E> node = new Node<E>(item);
			node.next = head;
			head = node;
			size++;
		}
		else
		{
			Node<E> current = head;
			for (int i=0; i<position-1;i++)
			{
				current = current.next;
			}
			Node<E> node = new Node<E>(item);
			current.next = node;
			size++;
		}


	}

	public E get (int position) throws Exception
	{
		if (position >= size || position < 0)
		{
			throw new Exception("Invalid position");
		}

		Node<E> node = head;
		for (int i = 0; i < position; i++)
		{
			node = node.next;
		}
		return node.data;
	}

	public E remove (int position) throws Exception
	{
		if (position >= size || position < 0)
		{
			throw new Exception("Invalid position");
		}
		if ( position == 0)
		{
			Node<E> node = head;
			head = head.next;
			size--;
			return node.data;
		}
		else
		{
			Node<E> prev = head;
			for (int i = 0; i < position-1; i++)
			{
				prev = prev.next;
			}
			Node<E> node = prev.next;
			prev.next = node.next;
			size--;
			return node.data;
		}
	}

	public E reverse (E head)
	{
		Node<E> previous = null;
		Node<E> current;
		Node<E> next = null;
		current = this.head;

		while ( current != null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous.data;
	}
}

class Node<E>
{
	E data;
	Node<E> next;

	public Node (E item)
	{
		this.data = item;
		this.next = null;
	}
}

