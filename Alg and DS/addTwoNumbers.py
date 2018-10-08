# From https://leetcode.com/problems/add-two-numbers/description/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        firstNum = 0;
        secondNum = 0;
        expo = 0;

        while l1 is not None:
            firstNum += (l1.val * 10**expo);
            expo += 1;
            l1 = l1.next;


        expo = 0;

        while l2 is not None:
            secondNum += (l2.val * 10**expo);
            expo += 1;
            l2 = l2.next;


        finalSum = firstNum + secondNum;

        sumInNodes = ListNode(finalSum % 10);
        head = sumInNodes;
        finalSum = finalSum / 10;

        while finalSum != 0:
            sumInNodes.next = ListNode(finalSum % 10);
            finalSum = finalSum / 10;
            sumInNodes = sumInNodes.next;


        return head;
