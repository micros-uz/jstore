--drop table Books;
--drop table Series;
--drop table Genres;
--drop table Authors;
--drop table Comments;
--drop table Posts;
--drop table Blogs;
--drop table Users;

insert into genres (title) values ('Poetry');
insert into genres (title) values ('Arts & Design');
insert into genres (title) values ('History');
insert into genres (title) values ('Philosofy');
insert into genres (title) values ('Fiction');
insert into genres (title) values ('Fantasy');
insert into genres (title) values ('Computer Science');
insert into genres (title) values ('Kid''s reading');
insert into genres (title) values ('Science & Technology');

insert into Authors (Name) values ('�������� �.');
insert into Authors (Name) values ('���������� �.');
insert into Authors (Name) values ('��. ������');
insert into Authors (Name) values ('��������� �. �.');
insert into Authors (Name) values ('������ �.');
insert into Authors (Name) values ('��������� �.');
insert into Authors (Name) values ('��������� �.');
insert into Authors (Name) values ('���� �.');
insert into Authors (Name) values ('�������� �.�.');
insert into Authors (Name) values ('������ �.�.');
insert into Authors (Name) values ('�������� �.�.');

insert into Series (Genre_Id, Title) values (9, '�������� computer science');
insert into Series (Genre_Id, Title) values (9, '������-�����');
insert into Series (Genre_Id, Title) values (9, '����������� O''Reilly');


insert into Books (author_id, genre_id, series_id,Title, Price, Year, Pages, ISBN, description) values (1, 9, 2, '���������������� � �������������� Microsoft ASP.NET 4', 1531, 2012, 880, '978-5-459-00346-8', '��� ����� ������������ ����� �������� ������ ����������� �� Microsoft ASP.NET, ��������� �������������� ��� ������ ASP.NET 4. �� ������� ��� ���� ������������ ������ ����������, � ��������� �� ������������� ���, �������� � �������� �������, ���������� ������������ ������ ��� ���������� � ��������� ���-����������, � ����� � ������ � Microsoft Silverlight � ASP.NET MVC. ������ �������� ��������� ������������ ���������� ���������� � ������������ ASP.NET, jQuery, AJAX � ��������� ��������������.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (2, 9, 2, '���������� ���������� Microsoft Windows. 6-� ���.', 1313, 2013, 800, '978-5-496-00434-3',        '������ ������� ���� ����������� ����� ��������� ����������� ���������� � ���������� ������ �������� ����������� ������������ ������� Microsoft Windows 7, � ����� Windows Server 2008 R2. ������������ �������� ������� � ������� Windows, ������ ������������� �� ���������������� ���������, ������������ ��� ������������ ����������� ���������� �������, ��������������� ����� ����������� � ���������� ��. ����� � ����� ������ ������������� � �������� ���������������� ��������� � ����������� ���������� Windows.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (3, 9, 2, 'CLR via C#. ���������������� �� ��������� Microsoft .NET Framework 4.5 �� ����� C#. 4-� ���.', 1238, 2013, 896, '978-5-496-00433-6',        '��������� ������� �����, ���������� ���������� ��������� � ������� ���������������� ������� �������� � ��� ������� ���������, ��������� ��������� � ������������ �� ������������� ��������� .NET Framework 4.5, � ����� ����� Visual Studio 2012 � C# 5.0.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (4, 9, 1, '������������ ����. 5-� ���.', 1238, 2012, 960, '978-5-4461-0068-2',        '����� ���� � ���������, ����� ������� ����� ������������ ����� �� ����������� ������� �����������, ���������� ���������� ��������� � ���� ������� ����� ����������� � ����������� � ����������� �������������� ������������ ������� ����������. ������ ������ ����� ������������� ����� ��������� �� ���� � ������� 1980 ����, � � ��� ��� ������ ������� ����� ��������� ����������� ������������ � �������������� � �������� �������� �������� � ������� ����������� �����. � ����� ��������������� �������� �������� ���������, ������������ ����������� ��������� � ��������� �������� ������������ �����. ������ ������������ ������� ��������� ���������� � �������� ������ ����������� � ������������ �����������, ������������� ��� ������� � ������ ����������� ����� � �� ����������� �� ������ ���������� ��������. ��������� ������������� ��������� ����������� ������, �������������� ��������� ���������������� ��������� � ������������ ����� ���������� ����. ����� ������� ��������� ������������ � ������ ���������, ����������� � ����� ������� ���������� �� ��������� ���� �, � ���������, �������� ����� �������, ��� ������������ ���� ��������� 802.12 � 802.16, ���� 3G, ���������� RFID, �������������� �������� �������� CDN, ���������� ����, ��������� �������, ��������-��������� � ������ ������.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (5, 9, 1, '��������-��������������� ���������������� � �++. ', 844, 2013, 928, '978-5-496-00353-7',        '��������� ���� ����� ������ ������������� �������� ����������� ��������-���������������� ���������������� � �++. � ��� ���� ���: �������� �������� �����, ������� ��������������� ����������, ��������� �������, ���������� ������, � ��������� �������� �����������. ����� ���������� ���������� ������� � ������� ���������� ��������� ����, ��� �������� ����� 100 ����������, ����������� ��������� ������ �� ���� �����. �������� ����� ������ �� ����� ���������� � ������� ����� �++. ���������� ���� ������ ��������� ����� ����������������.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (6, 9, 1, '����������� ���������� � �������������� ������������ ������.', 856, 2011, 784, '978-5-459-00291-1',        '�����, ��������� ��� � 4-� �������, ��������� ����������� ����������� ���������� � �������� ������������� ���������, ������������ � ������� ����������� �����������, � ��������� ������������� ������� �� ���������������� ������ � ������������ ����������������. � ������� �������� ����������� ����������� ���������� � ���������� ���� ��� �����������: �����������, ������ ������, ������� �����-������ � �������� ������. ������������� ������������ ����� �������� ������������ �������������� ����� ����������� ���������� � ��������� ����������� ������������. ������ �������� ��������� ������������ �������������� �������� � ������������� ����������������. �������������� ���������� � ������, ���������� ����� ������ ����, �������� ��������� ��������. ����� ���������� �� ������� ���� ���������: �� ���������, ��������� ������������ ����������, �� ������� �������������, ������� ����� ������� ����������� ��������� ������������������ ����������������. ');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (7, 9, 1, '���� ���������������� C#', 1188, 2011, 784, '978-5-459-00283-6',        '����� ���� � ��������� ������� ������� ����� �� ����� C#, ���������� �������� ���������������� � �������� �����������, ������������ C#, Delphi � Turbo Pascal, ��������� � ������� �������������, ���������� � ������ ������������� C# �������� Microsoft. ������� �������� �������� ������ ��������� ����� � ����� ������������ ���������� ���������� �� ���� ����, ����������� � ������� �������� ������������, ���������� � ���� �������� ����������, ������������� ��������� � �������, � ����� ������� ����. ��� ����� � ������ ���� �������� ������������, ������� � ��������� ����� �������� ��� MSDN, ��� � ��������� ����� �� C#. ��������� ������� �������� �������� ����� ������������ C# 4.0, ������� ������������ ����������, ����������� � �������������� ���������, � ����� ������������ � ���������������� ���������� ����. ���� ���� �������� � ���������� ������������ C# ��� �������������� � ���������, �� ������������ � ��������� .NET. ������������� ����������� ������ ������� ����� ������� � ���, ��� ������ ����� ����� �������� �������� �����������, ���������� ���������� ����� ����������������, ������ ��� ���� ����, ������ ���������, ���� ������, �������� ������, ���� ������� � ��.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (8, 9, 3, 'Hadoop. ��������� �����������', 938, 2013, 672, '978-5-496-00662-0',        'Apache Hadoop � ��������� � �������� �������� �����, � ������� ����������� �������������� ���������, ��������� ��� MapReduce, ����������� Google ��������� ���� �������. ��� ����� ������� ���, ��� ������������ ��� ���� Hadoop, ����� ��������� ��������, ��������������, �������������� ������� � ������������ ���������� ������ ������.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (9, 3, null, '1917. �������� "�������" ���������', 244, 2013, 416, '978-5-496-00464-0',        '������ ���������� ������� � 1917 ���� �� ���� ������������, ��� �� �������� ���������� � ��������� ����. � ����� ������� ������ ������� ���� ������������ ������ ������, ��������� �������� � �������, ������� �� ������ ��� �������� �������� � ����� ��������� ���� ����������� ������.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (10, 3, null, '�������. ������������� ������', 300, 2011, 432, '978-5-459-00881-4',        '��� �� �� ������ �������� � ����������� �������, ���������� ������������� ����������: ������ ���, ����� ������� �������� ������, ���� ������� � ��������� �������. ����� ��� �������� � ������ ���������� ��� ������� �� ������ �����, ��������� � ����� �������� �������� ������� ���������. ������ �������� ��������, ���������� ������������ �� ���������� ������� ���� ����� �����������, �������� � ���, ����� ������ �� ������! ����������� �� �������� ����� ��������� ���������, ��������, �������� ��������������� ������� �� ������������ ��� ������ ��������� ������������ ������ ������ � �����, ������������� ��������� �� �������� ���� ��� ����������. ����� ����� ������� ������� � ���, ��� ������� ��� � ������, ��� ���������� ������� ����������, ��� ���������� ��� ��� ������ ������ ������ ��������������� ������������, � � ���, ��� ������ � ������ ��������� � ����������� ���������� ������� � ����������� � ������ ��������� ����.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (11, 3, null, '������� ������. ������������ �� �������� ������', 194, 2010, 208, '978-5-4237-0033-1',        '�������� ���������� ���������� ������, ��������� �������� ���� �������, � ������ �� � �����, ���������� ����� ���������� � ���������� ������� � ������ ����������� ������� ������. ��� ��������� �������� ���������� �� ��������� �����, ��������� ������ � �������������, ����������� ������, �������� � ������ ����� � ������� ������, ������������ ������� ������ � ������ ���������� � ���? ��� �������� ����������� ���������� ������������ � ����� ���� ������ � ��� ������������ �������� ����? ���������� �� ������ ������������ ��� � ���������� ����� ������? ��� ����� ����� �������� ���������� � �����-���������? �� ��� � ������ ������� �������� ����� �������� � ��������, �������� ����������� ����, ������������� � ������� ������������ �������� � ��������������� ����������.');
insert into Books (author_id, genre_id, series_id, Title, Price, Year, Pages, ISBN, description) values (9, 3, null, '������. ���������� ������', 185, 2013, 416, '978-5-496-00223-3',        '� ����������� ������� ������ ��� ����� ���������� ��������, ��� ����� ������. ������ ���� �� �������� �����, � ������ ��� ������������ ������������ ��������������. ����� ������� ��������� ���������� �� ������������� ������������� � ���������� �������, ���������� � ������������ ������, ������� ��� ����� ������ �� �������� ������ �������:��� ���� ������� ��������� � ����������� ������? ������ ������������ ������� ������� ����� ���������� ���������? �� ��� ������ ������ ��� ��������� �������? ������ � ������ ������ ����� ��������� ��������� � ���� ����� ����������, � �� ����� � ��������? ��� ����� ������� ��� ����������� � ������� ������������ ����� � � �� ����� ������� �������� �. �. �������.');

drop table if exists UserConnection;
create table UserConnection (userId varchar(255) not null, providerId varchar(255) not null, providerUserId varchar(255), rank int not null,displayName varchar(255),profileUrl varchar(512),imageUrl varchar(512),accessToken varchar(255) not null,secret varchar(255),refreshToken varchar(255),expireTime bigint, primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);