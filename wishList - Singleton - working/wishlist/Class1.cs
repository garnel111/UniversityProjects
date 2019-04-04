sing System;


    [TestClass]
    public class WishlistTests
    {
        private MockRepository mockRepository;



        [TestInitialize]
        public void TestInitialize()
        {
            this.mockRepository = new MockRepository(MockBehavior.Strict);


        }

        [TestCleanup]
        public void TestCleanup()
        {
            this.mockRepository.VerifyAll();
        }

        private Wishlist CreateWishlist()
        {
            return new Wishlist();
        }

        [TestMethod]
        public void AddOrUpdateWishlistItem_StateUnderTest_ItemIsAdded()
        {
            // Arrange
            var items = new List<Item> {
                            new Item { Id = 1, Desc = "a"},
                            new Item { Id = 2, Desc = "b"},
                            new Item { Id = 3, Desc = "c"},
                        };
            itemToAdd = new Item { Id = 5, Desc = "F" };

        Wishlist wishlist = new Wishlist();
            wishlist.
        

               // Act

               // Assert
               Assert.Fail();
        }
    }

