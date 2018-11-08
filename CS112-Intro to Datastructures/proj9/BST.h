/* BST.h declares a "classic" binary search tree of linked nodes.
 * Joel Adams, for CS 112 at Calvin College.
 * Student Name:Joshua Maguire
 * Date:4/16/2013
 * 
 * Class Invariant:
 *   myNumItems == 0 && myRoot == NULL ||
 *   myNumItems > 0 && 
 *     myRoot stores the address of a Node containing an item &&
 *       all items in myRoot->myLeft are less than myRoot->myItem &&
 *       all items in myRoot->myRight are greater than myRoot->myItem.
 */

#ifndef BST_H_
#define BST_H_

#include "Exception.h"
#include <iostream>

using namespace std;

template <class Item>

class BST {
public:
	BST();
	virtual ~BST();
	bool isEmpty() const;
	unsigned getNumItems() const;
	void insert(const Item& it);
	bool contains(const Item& it) const;
	void traverseInorder();
	void traversePreorder();
	void traversePostorder();
	int getHeight() const;

private:
	struct Node {
	    Node(const Item& it);
            virtual ~Node();
			void insert(const Item& it);
			bool contains(const Item& it) const;
            void traverseInorder();
            void traversePreorder();
            void traversePostorder();
            virtual void processItem();
			int getHeight(int count) const;

		
            Item myItem;
            Node* myLeft;
            Node* myRight;
	};
	
	Node* myRoot;
	unsigned myNumItems;
	friend class BST_Tester;
};

template <class Item>
BST<Item>::BST()
{
	myRoot=NULL;
	myNumItems=0;
}

template <class Item>
BST<Item>::~BST() {
	delete myRoot;
	myRoot = NULL;
	myNumItems = 0;
}

template <class Item>
BST<Item>::Node::Node(const Item& it) {
	myItem = it;
	myLeft = NULL;
	myRight = NULL;
}

template <class Item>
BST<Item>::Node::~Node() {
	delete myLeft;
	delete myRight;
}

template <class Item>
bool BST<Item>::isEmpty() const {
	return myNumItems == 0;
}

template <class Item>
unsigned BST<Item>::getNumItems() const {
	return myNumItems;
}

template <class Item>
void BST<Item>::traversePreorder() {
	if ( !isEmpty() ) {
		myRoot->traversePreorder();
	}
}

template <class Item>
void BST<Item>::Node::traversePreorder() {
	processItem();
	if (myLeft != NULL) {
		myLeft->traversePreorder();
	}
	if (myRight != NULL) {
		myRight->traversePreorder();
	}
}

template <class Item>
void BST<Item>::Node::processItem() {
	cout << ' ' << myItem;
}

/*
This method searches through a tree and outputs 
its values after recursion has taken place(from right to left).
Recursion happens in the method below this one.
Post condition: i've couted the values in this tree
in a perticular order.
*/
template <class Item>
void BST<Item>::traversePostorder() {
	if ( !isEmpty() ) {
		myRoot->traversePostorder();
	}
}

template <class Item>
void BST<Item>::Node::traversePostorder() {
	if (myLeft != NULL) {
		myLeft->traversePostorder();
	}
	if (myRight != NULL) {
		myRight->traversePostorder();
	}
	processItem();
}

/*
This method searches through a tree and outputs 
its values in the right order.
Recursion happens in the method below this one.
Post condition: i've couted the values in this tree
in order.
*/
template <class Item>
void BST<Item>::traverseInorder() {
	if ( !isEmpty() ) {
		myRoot->traverseInorder();
	}
}

template <class Item>
void BST<Item>::Node::traverseInorder() {
	if (myLeft != NULL) {
		myLeft->traverseInorder();
	}
	processItem();
	if (myRight != NULL) {
		myRight->traverseInorder();
	}

}

template <class Item>
void BST<Item>::insert(const Item& it)
{
	if(myRoot==NULL)//empty tree case
	{
		myRoot=new Node(it);
		myNumItems++;
	}
	else
	{
		try{myRoot->insert(it);}catch (exception e1) {throw e1;}
		myNumItems++;
	}
}

template <class Item>
void BST<Item>::Node::insert(const Item& it)
{
	if(myItem==it){throw Exception("void BST::Node::insert(const Item& it)","Item already in BST!");}
	if(myLeft==NULL&& it < myItem)
	{
		myLeft=new Node(it);
		return;
	}
	else if(myRight==NULL&& it > myItem)
	{
		myRight=new Node(it);
		return;
	}
	else
	{
		if(it < myItem){myLeft->insert(it);}
		else{myRight->insert(it);}
	}
}

/*
This method searches through the binary search tree for a specific value it.
@param:const Item& it: the item im searching for
postcondition: returns bool
*/
template <class Item>
bool BST<Item>::contains(const Item& it) const
{
	if(myRoot==NULL){return false;}
	myRoot->contains(it);
}

/*
This is the Node method for the above method. It is recursive.
@param:const Item& it: the item im searching for
postcondition: returns bool
*/
template <class Item>
bool BST<Item>::Node::contains(const Item& it) const
{
	if(myItem==it){return true;}
	else if(myLeft!=NULL&&it<myItem){myLeft->contains(it);}
	else if(myRight!=NULL&&it>myItem){myRight->contains(it);}
	else{return false;}
}

/*
This method searches through a bst to figure out its height.
the Height is how "tall" a tree is: how many mods it is tall.
postcondition: returns how tall it is (int)
*/
template<class Item>
int BST<Item>::getHeight() const
{
	if(!myRoot){return 0;}
	return myRoot->getHeight(0);
}

/*
The node recursive node method for the above method
the Height is how "tall" a tree is: how many mods it is tall.
postcondition: returns how tall it it is from this nodes perspective(without
looking up). so if a tree is 5 tall, but were at a node 2 down, then from
that nodes perspective its 3 tall, and returns 3.
@param count:current height in tree
post condition:returns height of current node(from top to bottom)
*/
template<class Item>
int BST<Item>::Node::getHeight(int count) const
{
	int lCount=0;
	int rCount=0;
	if (myLeft != NULL)
	{
		lCount=myLeft->getHeight(count);
	}
	if (myRight != NULL) 
	{
		rCount=myRight->getHeight(count);
	}
	count++;
	if(lCount>rCount){return lCount+count;}
	else{return rCount+count;}
}
#endif /*BST_H_*/

