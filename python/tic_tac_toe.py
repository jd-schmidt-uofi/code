#!/usr/bin/env python3
"""Tic Tac Toe Game."""
# jd.schmidt11@gmail.com
# July 7, 2016

print("Welcome to Tic Tac Toe!")

board = [
    ["_", "_", "_"],
    ["_", "_", "_"],
    ["_", "_", "_"]
]

p1 = ['X', input("What is player 1's name?: ")]
p2 = ['O', input("What is player 2's name?: ")]

def print_board(board):
    for row in range(len(board)):
        print(" | ".join(board[row]))
        if row != 2:
            print("-----------")


def win(player):
    print("Player: %s has won the game!" % player[1])
    print_board(board)
    exit(0)


def get_move(player):
    """This gets user input for the column and for the row and assigns it into the board."""
    symbol = player[0]
    move_complete = False
    while not move_complete:
        print("player %s's turn." % player[1])
        column = 0
        row = 0
        while not 0 < row < 4:
            row = int(input("Please enter the row(1-3): "))
            while not 0 < column < 4:
                column = int(input("Please enter the column(1-3): "))
            print("move: %d,%d" % (row, column))
            if board[row-1][column-1] == "_":
                board[row-1][column-1] = symbol
                move_complete = True

                # Checking for a winner row
                if board[row-1] == ([symbol] * 3):
                    win(player)

                # check for winning column
                col_result = []
                for x in range(3):
                    col_result.append(board[x][column-1])

                if col_result == ([symbol] * 3):
                    win(player)

                # check for winnin diaganol (both ways)
                diag = []
                rev_diag = []

                for x in range(3):
                    diag.append(board[x][x])
                    rev_diag.append(board[2 - x][x])
                if diag == ([symbol] * 3) or rev_diag == ([symbol] * 3):
                    win(player)

            else:
                print("That is not a valid move!!!!")
                print_board(board)


def run_game():
    """main run function."""
    for x in range(10):
        print_board(board)
        if x == 9:
            print("That's unfortunate, it was a Draw!!")
            exit(1)
        elif x % 2 == 0:
            get_move(p1)
        else:
            get_move(p2)
    print_board(board)

run_game()
