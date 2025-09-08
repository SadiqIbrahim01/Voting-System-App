const prompt = require("prompt-sync")();

let availableBooks = [
  "Things fall Apart",
  "Son of the Soil",
  "Last Days at Forcados High",
  "Purple Hibiscus",
  "Face Me I Face You"
];

let borrowedBooks = [];

function viewAllBooks() {
  if (availableBooks.length === 0) {
    console.log("No books available right now.\n");
  } else {
    console.log("Available books are:");
    availableBooks.forEach(function(book) {
      console.log("- " + book);
    });
    console.log();
  }
}

console.log("--- Welcome to Library Tracker ---");

let choice;
do {
  console.log("\n1. View all books");
  console.log("2. Borrow a book");
  console.log("3. Return a book");
  console.log("4. Exit");

  choice = prompt("Select an option: ");

  switch (choice) {
    case "1":
      viewAllBooks();
      break;

    case "2":
      let borrowBook = prompt("What book would you like to borrow? ");
      let foundBorrow = false;
      for (let i = 0; i < availableBooks.length; i++) {
        if (availableBooks[i].toLowerCase() === borrowBook.toLowerCase()) {
          console.log(availableBooks[i] + " has been borrowed.\n");
          borrowedBooks.push(availableBooks[i]);
          availableBooks.splice(i, 1);
          foundBorrow = true;
          break;
        }
      }
      if (!foundBorrow) console.log("Book not found in library.\n");
      break;

    case "3":
      let returnBook = prompt("What book would you like to return? ");
      let foundReturn = false;
      for (let i = 0; i < borrowedBooks.length; i++) {
        if (borrowedBooks[i].toLowerCase() === returnBook.toLowerCase()) {
          console.log(borrowedBooks[i] + " has been returned.\n");
          availableBooks.push(borrowedBooks[i]);
          borrowedBooks.splice(i, 1);
          foundReturn = true;
          break;
        }
      }
      if (!foundReturn) console.log("This book was not borrowed.\n");
      break;

    case "4":
      console.log("Exiting... Goodbye!");
      break;

    default:
      console.log("Invalid option. Try again.");
  }
} while (choice !== "4");
