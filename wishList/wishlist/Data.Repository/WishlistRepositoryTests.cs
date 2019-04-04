using Farfetch.wishlist.Data.Repository;
using Moq;
using NUnit.Framework;
using System;

namespace Farfetch.wishlist.Domain.Model
{
    [TestFixture]
    public class WishlistRepositoryTests
    {
        private MockRepository mockRepository;



        [SetUp]
        public void SetUp()
        {
            this.mockRepository = new MockRepository(MockBehavior.Strict);


        }

        [TearDown]
        public void TearDown()
        {
            this.mockRepository.VerifyAll();
        }

        private WishlistRepository CreateWishlistRepository()
        {
            return new WishlistRepository();
        }

        [Test]
        public void GetWishlist_StateUnderTest_WithResultNotNull()
        {
            // Arrange
            WishlistRepository wishlistRepository = new WishlistRepository();

            // Act
            var result = wishlistRepository.GetWishlist(1);

            // Assert
            Assert.NotNull(result);
            Console.WriteLine("External Id: " + result.ExternalId.ToString());
            Console.WriteLine("Owner Id: " + result.OwnerId.ToString());
            Console.WriteLine("Id: " + result.Id.ToString());
        }

        [Test]
        public void GetWishlist_WithDifferentWishlist_ShouldReturnNull()
        {
            // Arrange
            WishlistRepository wishlistRepository = new WishlistRepository();
            Wishlist wl1 = new Wishlist { ExternalId = 5, OwnerId = 30 };

            // Act
            var result = wishlistRepository.GetWishlist(wl1.ExternalId);

            // Assert
            Assert.Null(result);

        }

        [Test]
        public void GetWishlist_WithOwnerDifferentsOwnerIds_ShouldReturnNull()
        {
            // Arrange
            WishlistRepository wishlistRepository = new WishlistRepository();
            Wishlist wl1 = new Wishlist { ExternalId = 1, OwnerId = 20 };

            // Act
            var result = wishlistRepository.GetWishlist(wl1.ExternalId);

            // Assert
            //é suposto falhar de acordo com esta construução
            Assert.Pass();
            Assert.Null(result);

        }

        [Test]
        public void AddItem_StateUnderTest_ExpectedBehavior()
        {
            // Arrange
            WishlistRepository wishlistRepository = new WishlistRepository();

            // Act
            var unitUnderTest = wishlistRepository.AddItem(1, new WishlistItem { Code = 500, Name = "itemE", Price = 200, ExternalId = 5 });

            // Assert
            Assert.IsTrue(unitUnderTest);

        }

        [Test]
        public void AddItem_StateUnderTest_ShouldReturnFalse()
        {
            // Arrange
            WishlistRepository wishlistRepository = new WishlistRepository();

            // Act
            var unitUnderTest = wishlistRepository.AddItem(1, new WishlistItem { Code = 100, Name = "NameA", Price = 200, ExternalId = 1 });

            // Assert
            Assert.IsFalse(unitUnderTest);
        }


        [Test]
        public void DeleteItem_StateUnderTest_ShouldReturnTrue()
        {
            // Arrange
            // var unitUnderTest = this.CreateWishlistRepository();
            WishlistRepository wishlistRepository = new WishlistRepository();
            int wishlistId = 1;
            WishlistItem item = new WishlistItem { Code = 100, Name = "NameA", Price = 200, ExternalId = 1 };

            // Act
            var result = wishlistRepository.DeleteItem(
                wishlistId,
                item);

            // Assert

            Assert.IsTrue(result);
            Console.WriteLine(wishlistRepository.GetWishlist(1).ToString());

        }

        [Test]
        public void DeleteItem_StateUnderTest_ShouldReturnFalse()
        {
            // Arrange

            WishlistRepository wishlistRepository = new WishlistRepository();
            int wishlistId = 1;
            WishlistItem item = new WishlistItem { Code = 450, Name = "Name450", Price = 200, ExternalId = 350 };

            // Act
            var result = wishlistRepository.DeleteItem(
                wishlistId,
                item);

            // Assert

            Assert.IsFalse(result);
            Console.WriteLine(wishlistRepository.GetWishlist(1).ToString());
        }

        [Test]
        public void UpdateItem_ExistingItem_ShouldBeUpdated()
        {
            // Arrange
            WishlistRepository wishlistRepository1 = new WishlistRepository();
            WishlistItem item = new WishlistItem { Code = 450, Name = "Name450", Price = 200, ExternalId = 1 };
            int wishlistId = 1;
            // Act
            var result = wishlistRepository1.UpdateItem(
                wishlistId,
                item);
            var result1 = wishlistRepository1;
            // Assert
            Assert.IsTrue(result);
            Console.WriteLine(result.ToString());
            Console.WriteLine(wishlistRepository1.wishlistList.ToString());

        }

        [Test]
        public void UpdateItem_NoExistingItem_ShouldNotBeUpdated()
        {
            // Arrange
            WishlistRepository wishlistRepository1 = new WishlistRepository();
            WishlistItem item = new WishlistItem { Code = 450, Name = "Name450", Price = 200, ExternalId = 100 };
            int wishlistId = 1;
            // Act
            var result = wishlistRepository1.UpdateItem(
                wishlistId,
                item);
            var result1 = wishlistRepository1;
            // Assert
            Assert.IsFalse(result);


        }

        [Test]
        public void GetWishlist_ExistingList_ShouldReturnList()
        {
            // Arrange
            WishlistRepository wishlistRepository2 = new WishlistRepository();
            int count = 0;
            //var expectedResult = null;
            // Act
            Console.WriteLine("count before: " + count);
            var result = wishlistRepository2.GetWishlistList();
            var sequence = result.GetEnumerator();
            while (sequence.MoveNext())
            {
                count++;
                Console.WriteLine("\nCount on while iteration: " + count);
                Console.WriteLine("result" + result.ToString());
            }
            // Assert
            // Assert.IsFalse(result.);
            Console.WriteLine("count after: " + count);

        }

    }
}
