#include <stdlib.h>
#include <string.h>

#include "singleLinkedList.h"

void init(SingleLinkedList *list, void (*destroy)(void *data)) 
{
	list -> size = 0;
	list -> destroy = destroy;
	list -> head = NULL;
	list -> tail = NULL;

	return;
}

void destroy(SingleLinkedList *list)
{	
	void *data;
	while (size(list) > 0) {
		if (remove(list, NULL, (void **)&data) == 0 && list -> destroy != NULL) {
			list -> destroy(data);
		}
	}
	memset(list, 0, sizeof(SingleLinkedList));
	return;
}

int insert(SingleLinkedList *list, Node *node, const void **data) {
	Node *newNode;
	if ((newNode = (Node *)malloc(sizeof(Node))) == NULL) { //메모리할당
		return -1;
	}

	newNode -> data = (void *)data;
	
	if (node == NULL) {
		if (size(list) == 0) {
			list -> tail = newNode;
		}
		newNode -> next = list -> head;
		list -> head = newNode;
	} else {
		if (node -> next == NULL) {
			list -> tail = newNode;
		}
		newNode -> next = node -> next;
		node -> next = newNode;
	}
	list -> size++;
	return 0;
}

int remove(SingleLinkedList * list, Node *node, void **data) {
	Node *oldNode;
	if (list -> size == 0) {
		return -1;
	}
	if (node == NULL) {
		*data = list -> head -> data;
		oldNode = list -> head;
		list -> head = list -> head -> next;
		if (sizeof(list) == 0) {
			list -> tail = NULL;
		}
	} else {
		if (node -> next == NULL) {
			return -1;
		}
		*data = node -> next -> data;
		oldNode = node -> next;
		node -> next = node -> next -> next;
		if (node -> next == NULL) {
			list -> tail = node;
		}

	}
	free(oldNode);
	list -> size--;
	return 0;
}