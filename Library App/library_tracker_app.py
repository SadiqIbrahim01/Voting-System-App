available_books = [
    "Things fall Apart",
    "Son of the Soil",
    "Last Days at Forcados High",
    "Purple Hibiscus",
    "Face Me I Face You"
]

borrowed_books = []

def view_all_books():
    if not available_books:
        print("No books available right now.\n")
    else:
        print("Available books are:")
        for book in available_books:
            print("- " + book)
        print()

print("--- Welcome to Library Tracker ---")

while True:
    print("\n1. View all books")
    print("2. Borrow a book")
    print("3. Return a book")
    print("4. Exit")
    choice = input("Select an option: ")

    if choice == "1":
        view_all_books()

    elif choice == "2":
        borrow_book = input("What book would you like to borrow? ")
        for i in range(len(available_books)):
            if available_books[i].lower() == borrow_book.lower():
                print(available_books[i], "has been borrowed.\n")
                borrowed_books.append(available_books[i])
                available_books.pop(i)
                break
            elif i == len(available_books) - 1:
                print("Book not found in library.\n")

    elif choice == "3":
        return_book = input("What book would you like to return? ")
        for i in range(len(borrowed_books)):
            if borrowed_books[i].lower() == return_book.lower():
                print(borrowed_books[i], "has been returned.\n")
                available_books.append(borrowed_books[i])
                borrowed_books.pop(i)
                break
            elif i == len(borrowed_books) - 1:
                print("This book was not borrowed.\n")

    elif choice == "4":
        print("Exiting... Goodbye!")
        break

    else:
        print("Invalid option. Try again.")
