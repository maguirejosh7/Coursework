/*
 * List.h
 *
 *  Created on: Mar 5, 2013
 *      Author: jlm54
 */

#ifndef LIST_H_
#define LIST_H_

typedef double Item;

class List {
public:
	List();
	virtual ~List();
	unsigned getSize() const;
	Item getFirst() const;
	Item getLast() const;
	void append(const Item& it);
	List(const List& original);
	List& operator=(const List& original);

private:
	struct Node{
		Node();
		Node(Item it, Node *next);
		~Node();
		Item myItem;
		Node *myNext;
	};
	unsigned mySize;
	Node *myFirst;
	Node *myLast;
	friend class ListTester;
};

#endif /* LIST_H_ */
