/* BST.cpp defines binary search tree methods.
* Joel Adams, for CS 112 at Calvin College.
* Student Name:Joshua Maguire
* Date:4/16/2013
*/

#include "BST.h"

BST::BST()
{
	myRoot=NULL;
	myNumItems=0;
}


BST::~BST() {
	delete myRoot;
	myRoot = NULL;
	myNumItems = 0;
}

BST::Node::Node(const Item& it) {
	myItem = it;
	myLeft = NULL;
	myRight = NULL;
}

BST::Node::~Node() {
	delete myLeft;
	delete myRight;
}

bool BST::isEmpty() const {
	return myNumItems == 0;
}

unsigned BST::getNumItems() const {
	return myNumItems;
}

void BST::traversePreorder() {
	if ( !isEmpty() ) {
		myRoot->traversePreorder();
	}
}

void BST::Node::traversePreorder() {
	processItem();
	if (myLeft != NULL) {
		myLeft->traversePreorder();
	}
	if (myRight != NULL) {
		myRight->traversePreorder();
	}
}

void BST::Node::processItem() {
	cout << ' ' << myItem;
}

void BST::traversePostorder() {
	if ( !isEmpty() ) {
		myRoot->traversePostorder();
	}
}

void BST::Node::traversePostorder() {
	if (myLeft != NULL) {
		myLeft->traversePostorder();
	}
	if (myRight != NULL) {
		myRight->traversePostorder();
	}
	processItem();
}

void BST::traverseInorder() {
	if ( !isEmpty() ) {
		myRoot->traverseInorder();
	}
}

void BST::Node::traverseInorder() {
	if (myLeft != NULL) {
		myLeft->traverseInorder();
	}
	processItem();
	if (myRight != NULL) {
		myRight->traverseInorder();
	}

}

void BST::insert(const Item& it)
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

void BST::Node::insert(const Item& it)
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

bool BST::contains(const Item& it) const
{
	if(myRoot==NULL){return false;}
	//if(myRoot->myItem==it){return true;}
	myRoot->contains(it);
}

bool BST::Node::contains(const Item& it) const
{
	if(myItem==it){return true;}
	else if(myLeft!=NULL&&it<myItem){myLeft->contains(it);}
	else if(myRight!=NULL&&it>myItem){myRight->contains(it);}
	else{return false;}
}