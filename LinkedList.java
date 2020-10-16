public class LinkedList
{
	private class Node<E>
	{
		E data;
		Node next;

		public Node (E item)
		{
			data = item;
			next = null;
		}
	}

	private Node head;
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
			head = new Node(item);
			size++;
		}
		Node current = head;
		for (int i =0; i<size;i++)
		{
			current = current.next;
		}
		Node node = new Node(item);
		current.next = node;
		size++;
	}

	public void add (E item, int position) throws Exception
	{
		if (position >= size || position < 0)
		{
			throw new Exception("Invalid postion.");
		}
		if (postion == 0)
		{
			Node node = new Node(item);
			node.next = head;
			head = node;
			size++;
		}
		else
		{
			Node current = head;
			for (int i=0; i<position-1;i++)
			{
				current = current.next;
			}
			Node node = new Node(item);
			current.next = node;
			size++;
		}


	}

	public E get (int position) throws Exception
	{
		if (postion >= size || position < 0)
		{
			throw new Exception("Invalid position");
			return null;
		}

		Node node = head;
		for (int i = 0; i < position; i++)
		{
			node = node.next;
		}
		return node.data;
	}

	public E remove (int position) throws Exception
	{
		if (postion >= size || position < 0)
		{
			throw new Exception("Invalid position");
			return null;
		}
		if ( postion == 0)
		{
			Node node = head;
			head = head.next;
			size--;
			return node.data;
		}
		else
		{
			Node prev = head;
			for (int i = 0; i < position-1; i++)
			{
				prev = prev.next;
			}
			Node node = prev.next;
			prev.next = node.next;
			size--;
			return node.data;
		}
	}

	public E reverse (E head)
	{
		Node previous = null;
		Node current = head;
		Node next = null;

		while ( current != NULL)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous.data;
	}
}
