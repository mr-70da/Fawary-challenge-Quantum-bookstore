# Quantum Book Store
a Java-based CLI application to manage an online bookstore with multiple book types. This project demonstrates OOP principles, extensibility, and solid design practices.
![image](https://github.com/user-attachments/assets/7585bb56-b7ff-40be-9363-cb6968c849d6)
- Support three types of books: Ebooks, paper books and Showcase.
- 
Provides also inventory Mangement:
- Add a book with: `ISBN`, `Title`, `Published Year`, `Price`, `Author Name`
- Remove outdated books based on a threshold year
- Search for books by ISBN

Provides mechanism for:
- Buy a book by providing ISBN, quantity, user email, and address
- Automatically calculates total cost
- try demo books before you buy by provideing ISBN.

Provide mechanism for catching unexpected error:
- Buying more than available stock
- Buying ebooks with wrong quantity
- Trying to buy a Showcase / Demo book
- Searching for unknown ISBNs.

Developed by Mahmoud Ayman Ramdan mahmoudsebeai@gmail.com
