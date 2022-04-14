DROP TABLE Authors CASCADE;
DROP TABLE Books CASCADE;
DROP TABLE Users CASCADE;
DROP TABLE Credit CASCADE;
DROP TABLE Cart CASCADE;
DROP TABLE Ratings CASCADE;
DROP TABLE Comments CASCADE;
DROP TABLE Wishlists CASCADE;

CREATE TABLE Authors (
	author_id SERIAL NOT NULL PRIMARY KEY,
	first_name text NOT NULL,
	last_name text NOT NULL,
	biography text,
	publisher text
);

CREATE TABLE Books (
    book_id text NOT NULL PRIMARY KEY,
    book_name text NOT NULL UNIQUE,
    book_des text NOT NULL,
    book_price decimal NOT NULL,
    book_genre text NOT NULL,
    book_publisher text NOT NULL,
    book_year int,
    book_sales integer,
    author_name text NOT NULL
);

INSERT INTO Authors VALUES (
    DEFAULT,
	'Stephen',
	'King',
	'Stephen Edwin King is an American author of horror, supernatural fiction, suspense, crime, science-fiction, and fantasy novels',
	'Scribner'
);

INSERT INTO Books VALUES (
    9781501156700,
    'Pet Semetary',
    'It is a horror book about a dead cat',
    9.99,
    'horror',
    'Simon & Schuster',
    1983,
    0,
    'Stephen King'
);

INSERT INTO Authors VALUES (
	DEFAULT,
    'J.K.',
	'Rowling',
	'Joanne Rowling, CH OBE HonFRSE FRCPE FRSL, is a British author and philanthropist known by her pen name J. K. Rowling. 
	She wrote a seven-volume children''s fantasy series, Harry Potter, published from 1997 to 2007.',
	'Bloomsbury Publishing'
);

INSERT INTO Books VALUES (
    0747532699,
    'Harry Potter and the Sorcerer''s Stone',
    'You''re a wizard, Harry.',
    11.99,
    'fantasy',
    'Bloomsbury',
    1997,
    0,
    'J.K. Rowling'
);

CREATE TABLE Users (
    user_uname VARCHAR(255) PRIMARY KEY,
	user_email VARCHAR(255),
	--CHECK substring(user_email from '%#"@#"_' for '#')
    user_pword VARCHAR(255) NOT NULL,
    user_address VARCHAR(255),
    user_name VARCHAR(255)
);

INSERT INTO Users
VALUES
(
    'JVILL272',
	'jvill272@fiu.edu',
    'Password',
    '123 Main St',
    'Jorge Villacorta'
);

INSERT INTO Users
VALUES
(
    'BWAT001',
	'bwat001@fiu.edu',
    'SECONDPword',
    '987 First St',
    'Brandon Wat'
);

INSERT INTO Users
VALUES
(
    'MWONG035',
	'mwong035@fiu.edu',
    'THIRDPword',
    '123 Fake St',
    'Michael Wong'
);

CREATE TABLE Credit (
    card_number integer PRIMARY KEY,    
    fk_user_uname text, 
     CONSTRAINT fk_user_uname
                FOREIGN KEY (fk_user_uname)
                REFERENCES Users (user_uname),
    card_exdate date NOT NULL,
    card_ccv int NOT NULL
);

INSERT INTO Credit
VALUES
(
    1234567890,
   (SELECT(user_uname) FROM Users WHERE user_uname = 'JVILL272'),
    TO_DATE('04/24/2024', 'MM/DD/YYYY'),
    000
);

CREATE TABLE Cart (
    fk_cart_user text,
    CONSTRAINT fk_cart_user
        FOREIGN KEY (fk_cart_user) 
		REFERENCES Users (user_uname), 
    fk_cart_bname text,
    CONSTRAINT fk_cart_bname
        FOREIGN KEY (fk_cart_bname) 
		REFERENCES Books (book_name)
);

INSERT INTO Cart VALUES (
    (SELECT(user_uname) FROM Users WHERE user_uname = 'JVILL272'),
    (SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
);

INSERT INTO Cart VALUES (
    (SELECT(user_uname) FROM Users WHERE user_uname = 'BWAT001'),
    (SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
);

CREATE TABLE Ratings (
    rating integer 
	CHECK (rating > 0 AND rating < 6) NOT NULL,
    rating_date date NOT NULL,
    fk_book_rater text,
    CONSTRAINT fk_book_rater
        FOREIGN KEY (fk_book_rater)
		REFERENCES Users (user_uname),
    fk_rating_bname text,
    CONSTRAINT fk_rating_bname
        FOREIGN KEY (fk_rating_bname)
		REFERENCES Books (book_name),
	PRIMARY KEY(fk_book_rater,fk_rating_bname)
);
INSERT INTO Ratings VALUES (
        '1',
        TO_DATE('02/13/2022', 'MM/DD/YYYY'),
		(SELECT(user_uname) FROM Users WHERE user_uname = 'BWAT001'),
		(SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
);

INSERT INTO Ratings VALUES (
        '5',
        TO_DATE('02/12/2022', 'MM/DD/YYYY'),
		(SELECT(user_uname) FROM Users WHERE user_uname = 'JVILL272'),
		(SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
);

CREATE TABLE Comments (
    comment_text text NOT NULL,
	comment_date date NOT NULL,
    fk_book_commenter text,
        CONSTRAINT fk_book_commenter
           FOREIGN KEY (fk_book_commenter)
           REFERENCES Users (user_uname),
    fk_comment_bname text,
       CONSTRAINT fk_comment_bname
           FOREIGN KEY (fk_comment_bname)
           REFERENCES Books (book_name),
    PRIMARY KEY(fk_book_commenter, fk_comment_bname)
);


INSERT INTO Comments 
Values
(
    'This books is so cool, man.',
	'03-05-2022',
	(SELECT(user_uname) FROM Users WHERE user_uname = 'JVILL272'),
	(SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
);

INSERT INTO Comments
Values 
(
    'This books is terrible. BOOOO',
	'03-05-2022',
	(SELECT(user_uname) FROM Users WHERE user_uname = 'BWAT001'),
	(SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
);

SELECT Ratings.fk_book_rater, Ratings.fk_rating_bname, Ratings.rating, Comments.comment_text
FROM Ratings
INNER JOIN Comments ON Ratings.fk_book_rater=Comments.fk_book_commenter;


CREATE TABLE Wishlists (
    --Name of the wishlist
    list_name text PRIMARY KEY, 
    fk_list_creator text, 
    CONSTRAINT fk_list_creator
        FOREIGN KEY (fk_list_creator) 
		REFERENCES Users (user_uname), 
    fk_list_bname text, 
    CONSTRAINT fk_list_bname
        FOREIGN KEY (fk_list_bname) 
		REFERENCES Books (book_name)
);

INSERT INTO Wishlists VALUES
(
    'Jorge''s List',
    (SELECT(user_uname) FROM Users WHERE user_uname = 'JVILL272'),
    (SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
);

INSERT INTO Wishlists VALUES
(
    'The Other List',
    (SELECT(user_uname) FROM Users WHERE user_uname = 'BWAT001'),
    (SELECT(book_name) FROM Books WHERE book_name = 'Pet Semetary')
)