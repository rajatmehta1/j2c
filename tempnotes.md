CAP Theorem:

In this lesson I am going to cover CAP Theorem.
This is one of the most important theorems in distributed computing.
So, what exactly is CAP Theorem?
CAP stands for Consistency, Availability and Partitioning
It is a very simple theorem that states that at any point of time in a distributed system we can have only two out of these three possible properties i.e. Consistency, Availability or Partitioning.
So, let’s take the case of NoSQL dbs as given in the example here Availability goes with Partitioning but then consistency is left out. NoSQL databases follow the concept of eventual consistency. According to which data that is committed across different boxes in a distributed system is made available over a period of time that is to say eventually the commits will be made across all the nodes sharing the data. So NoSQL databases in order to become highly scalable they given up on consistency. As an example if you are liking a comment on a youtube video, this like can be eventually stored in a nosql database. It doesnot matter to the end users whether this like appears immediately or few seconds down the line, so in this case eventual consistency is a good solution, but the amount of likes happening in the system could be huge e.g. as in facebook so the overall scalability needed might be high, hence the use of nosql database makes sense here.
Relational databases on the other hand are highly consistent and available. But they are not easily scalable. Due to things like distributed joins the relational databases are not very scalable but they are highly available. They are best suited for application that require consistency and availability. For example an order booking system of a website, where the customer is placing the order. The system needs to be consistent so that the placed orders are immediately updated in the system.


So what does this consistency , availability and partitioning mean.
Consistency : in a distributed system you have data stored on multiple machines. When an update, delete or insert is fired on some data the updates are made consistently across all the machines, thereby all the machines storing that data are in the same state. For e.g. if you are storing say feedback from a user on 3 boxes and if the user now adds a new feedback or review, the new feedback is copied across all the 3 boxes at the same time and there is no time lag between the updates across all the boxes.
Next lets talk about Availability.
Availability : as the name suggest means the distributed system is available. In a distributed system we have multiple machines and if few machines fail and the system is still up that means its highly available and is able to run despite having failures.

Partitioning: is a very important concept for a distributed system. Basically the amount of data is so huge that it might not fit on the disk of a single machine and thereby the data is broken into chunks and then these chunks are stored across multiple machines. This helps the system to scale horizontally. That is to say you can add more machines in the system and the newer machines can become part of these partitions and start sharing more data thereby the system becomes more scalable.
------

Cap Theorems usage in the real world.
Cap theorem has lot of practical use and some of the top software systems of the world are using this theorem to scale their systems. For e.g. twitter has given up consistency to by not using distributed transactions and instead relies on high availability and scalability through partitioning. 
Also as example on twitter when you post comments they are not updated immediately into the database, although they eventually land up there.



