INSERT INTO User
        (UserId, UserName)
VALUES  (1     , 'Dave'  ),
        (2     , 'Christina'),
        (3     , 'Sydney' ),
        (4     , 'Reagan' );


INSERT INTO CalendarType
        (CalendarTypeId, CalendarTypeName)
VALUES  (1             , 'test'),
        (2             , 'test'),
        (3             , 'test'),
        (4             , 'test'),
        (5             , 'test'),
        (6             , 'test'),
        (7             , 'test'),
        (8             , 'test');


INSERT INTO Location
        (LocationId, LocationName)
VALUES  (1         , 'test'     ),
        (2         , 'test'     ),
        (3         , 'test'     ),
        (4         , 'test'     ),
        (5         , 'test'     ),
        (6         , 'test'     ),
        (7         , 'test'     ),
        (8         , 'test'     );


INSERT INTO EventCalendar
        (CalendarId, Description, UserId, Reminder, SpecialEvents, LocationId, CalendarTypeId)
VALUES  (1         , 'test'     , 1     , 'test'  , 'test'       , 1         , 1             ),
        (2         , 'test'     , 2     , 'test'  , 'test'       , 2         , 2             ),
        (3         , 'test'     , 3     , 'test'  , 'test'       , 3         , 3             ),
        (4         , 'test'     , 4     , 'test'  , 'test'       , 4         , 4             ),
        (5         , 'test'     , 1     , 'test'  , 'test'       , 5         , 5             ),
        (6         , 'test'     , 2     , 'test'  , 'test'       , 6         , 6             ),
        (7         , 'test'     , 3     , 'test'  , 'test'       , 7         , 7             ),
        (8         , 'test'     , 4     , 'test'  , 'test'       , 8         , 8             );

INSERT INTO ShoppingList
        (ShoppingListId, ShoppingListName)
VALUES  (1             , 'test'          ),
        (2             , 'test'          ),
        (3             , 'test'          ),
        (4             , 'test'          ),
        (5             , 'test'          ),
        (6             , 'test'          ),
        (7             , 'test'          ),
        (8             , 'test'          );


INSERT INTO ShoppingListItem
        (ListId, ShoppingListId, Item, LocationId, UserId)
VALUES  (1     , 1             , 'test', 1        , 1     ),
        (2     , 2             , 'test', 2        , 2     ),
        (3     , 3             , 'test', 3        , 3     ),
        (4     , 4             , 'test', 4        , 4     ),
        (5     , 5             , 'test', 5        , 1     ),
        (6     , 6             , 'test', 6        , 2     ),
        (7     , 7             , 'test', 7        , 3     ),
        (8     , 8             , 'test', 8        , 4     );









