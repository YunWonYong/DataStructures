#ifndef SINGLELINKEDLIST_H
#define SINGLELINKEDLIST_H

#include <stdio.h>

typedef struct Node_ {
	void* data;
	struct Node_* next;
} Node;

typedef struct SingleLinkedList_ {
	int size;

	void (*destroy)(void* data);

	Node* head;
	Node* tail;
} SingleLinkedList;

void init(SingleLinkedList *list, void (*destory)(void *data));
void destroy(SingleLinkedList *list);
int insert(SingleLinkedList *list, Node *node, const void **data);
int remove(SingleLinkedList *list, Node *node, void **data);

#define size(list) ((list) -> size )
#define head(list) ((list) -> head)
#define tail(list) ((list) -> tail)
#define isHead(list, node) ((node) == (list) -> head ? 1: 0)
#define isTail(node) ((node) -> next == NULL ? 1: 0)
#define data(node) ((node) -> data)
#define next(node) ((node) -> next)

#endif