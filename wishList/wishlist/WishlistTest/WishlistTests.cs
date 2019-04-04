using Farfetch.wishlist.Domain.Model;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using System.Collections.Generic;

namespace DomainTest
{
    [TestClass]
    public class WishlistTest
    {


        private MockRepository mockRepository;
        List<WishlistItem> itemsListToCompare = new List<WishlistItem> {
                                    new WishlistItem { ExternalId = 1, Name = "a"},
                                    new WishlistItem { ExternalId = 2, Name = "b"},
                                    new WishlistItem { ExternalId = 3, Name = "c"},
                                    new WishlistItem { ExternalId = 5, Name = "F" }
        };
        Wishlist wishlist = new Wishlist();
        Wishlist wishlistToCompare = new Wishlist();
        Wishlist wishlistToUpdate = new Wishlist();

        public MockRepository MockRepository { get => mockRepository; set => mockRepository = value; }

        [TestInitialize]
        public void TestInitialize()
        {
            this.MockRepository = new MockRepository(MockBehavior.Strict);
            List<WishlistItem> itemsListToCompare = new List<WishlistItem> {
                                    new WishlistItem { ExternalId = 1, Name = "a"},
                                    new WishlistItem { ExternalId = 2, Name = "b"},
                                    new WishlistItem { ExternalId = 3, Name = "c"},
                                    new WishlistItem { ExternalId = 5, Name = "F" }
        };

            wishlistToCompare.AddOrUpdateWishlistItem(new WishlistItem { ExternalId = 1, Name = "A" });
            wishlistToUpdate.AddOrUpdateWishlistItem(new WishlistItem { ExternalId = 7, Name = "a" });
            wishlistToUpdate.AddOrUpdateWishlistItem(new WishlistItem { ExternalId = 5, Name = "Z" });
        }

        [TestCleanup]
        public void TestCleanup()
        {
            this.MockRepository.VerifyAll();
        }

        private Wishlist CreateWishlist()
        {
            return new Wishlist();
        }

        [TestMethod]
        public void AddOrUpdateWishlistItem_StateUnderTest_ItemIsAdded()
        {
            // Arrange


            var itemToAdd = new WishlistItem { ExternalId = 5, Name = "F" };
            List<Wishlist> wishlistList = new List<Wishlist> { new Wishlist { ExternalId = 1, OwnerId = 10,  Items =  new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, ExternalId = 1 } , new WishlistItem { Code = 200, Name = "nameb", Price = 200, ExternalId = 2 } } },
                                                     new Wishlist { ExternalId = 2, OwnerId = 20, Items =  new List<WishlistItem> { new WishlistItem { Code = 300, Name = "namec", Price = 200, ExternalId = 3} , new WishlistItem { Code = 400, Name = "named", Price = 200, ExternalId = 4} } },
                                                     new Wishlist { ExternalId = 3, OwnerId = 20, Items = null }};

            Wishlist wl = new Wishlist
            {
                ExternalId = 1,
                OwnerId = 10,
                Items = new List<WishlistItem> { new WishlistItem { Code = 100, Name = "namea", Price = 200, ExternalId = 1 }, new WishlistItem { Code = 200, Name = "nameb", Price = 200, ExternalId = 2 } }
            };
            // Act

            wl.AddOrUpdateWishlistItem(itemToAdd);

            var result = wl.GetWishListItemById(5);

            // Assert
            Assert.AreEqual(itemToAdd, result);

        }

        [TestMethod]
        public void AddOrUpdateWishlistItem_StateUnderTest_ItemIsUpdated()
        {
            // Arrange
            wishlistToUpdate.AddOrUpdateWishlistItem(new WishlistItem { ExternalId = 1, Name = "A" });

            // Act
            var result = wishlistToUpdate.GetWishListItemById(1);

            // Assert
            Assert.AreNotEqual(new WishlistItem { ExternalId = 1, Name = "a" }, result);
        }
    }
}

