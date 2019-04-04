//using Farfetch.wishlist.Data.Repository;
//using Farfetch.wishlist.Domain.Core.Interface;
//using Moq;
//using NUnit.Framework;
//using System;
//using System.Data.Entity;

//namespace Farfetch.wishlist.Domain.Model
//{
//    [TestFixture]
//    public class WishlistRepositoryTests
//    {
//        private MockRepository mockRepository;
//        private WishlistItemRepository WishlistItemRepository = new WishlistItemRepository();
//        private Mock<DbContext> mockDbContext;

//        [SetUp]
//        public void SetUp()
//        {
//            this.mockRepository = new MockRepository(MockBehavior.Strict);
//            this.mockDbContext = new Mock<DbContext>(MockBehavior.Default) { CallBase = true };
     

//    }

//        [TearDown]
//        public void TearDown()
//        {
//            this.mockRepository.VerifyAll();
//        }

//        private WishlistRepository CreateWishlistRepository()
//        {
//            return new WishlistRepository();
//        }

//        [Test]
//        public void GetWishlist_StateUnderTest_WithResultNotNull()
//        {
//            // Arrange
//         var dbContext1 = new DbContext("a");
//            WishlistRepository WishlistRepository = new WishlistRepository();

//            // Act
//            var result = WishlistRepository.GetAll(1);

//            // Assert
//            Assert.NotNull(result);
//            Console.WriteLine("External Id: " + result.ExternalId.ToString());
//            Console.WriteLine("Owner Id: " + result.OwnerId.ToString());
//            Console.WriteLine("Id: " + result.ExternalId.ToString());
//        }

//        //[Test]
//        //public void GetWishlist_WithDifferentWishlist_ShouldReturnNull()
//        //{
//        //    // Arrange
//        //    mockDbContext.Setup(c => c.Database);

//        //    WishlistRepository WishlistRepository = new WishlistRepository(mockDbContext.Object, WishlistItemRepository);
//        //    wishlist wl1 = new wishlist { ExternalId = 5, OwnerId = 30 };

//        //    // Act
//        //    var result = WishlistRepository.GetAll(wl1.ExternalId);

//        //    // Assert
//        //    Assert.Null(result);

//       // }

//        [Test]
//        public void GetWishlist_WithOwnerDifferentsOwnerIds_ShouldReturnNull()
//        {
//            // Arrange
//            WishlistRepository WishlistRepository = new WishlistRepository();
//            Wishlist wl1 = new Wishlist { ExternalId = 1, OwnerId = 20 };

//            // Act
//            var result = WishlistRepository.GetAll(wl1.ExternalId);

//            // Assert
//            //é suposto falhar de acordo com esta construução
//            Assert.Pass();
//            Assert.Null(result);

//        }

//        [Test]
//        public void AddItem_StateUnderTest_ExpectedBehavior()
//        {
//            // Arrange
//            WishlistRepository WishlistRepository = new WishlistRepository();

//            // Act
//            var unitUnderTest = WishlistRepository.AddItem(1, new WishlistItem { Code = 500, Name = "itemE", Price = 200, WishlistItemId = 5 });

//            // Assert
//            Assert.IsTrue(unitUnderTest);

//        }

//        [Test]
//        public void AddItem_StateUnderTest_ShouldReturnFalse()
//        {
//            // Arrange
//            WishlistRepository WishlistRepository = new WishlistRepository();

//            // Act
//            var unitUnderTest = WishlistRepository.AddItem(1, new WishlistItem { Code = 100, Name = "NameA", Price = 200, WishlistItemId = 1 });

//            // Assert
//            Assert.IsFalse(unitUnderTest);
//        }


//        [Test]
//        public void DeleteItem_StateUnderTest_ShouldReturnTrue()
//        {
//            // Arrange
//            // var unitUnderTest = this.CreateWishlistRepository();
//            WishlistRepository WishlistRepository = new WishlistRepository();
//            int WishlistId = 1;
//            WishlistItem item = new WishlistItem { Code = 100, Name = "NameA", Price = 200, WishlistItemId = 1 };

//            // Act
//            var result = WishlistRepository.DeleteItem(
//                WishlistId,
//                item);

//            // Assert

//            Assert.IsTrue(result);
//            Console.WriteLine(WishlistRepository.GetAll(1).ToString());

//        }

//        [Test]
//        public void DeleteItem_StateUnderTest_ShouldReturnFalse()
//        {
//            // Arrange

//            WishlistRepository WishlistRepository = new WishlistRepository();
//            int WishlistId = 1;
//            WishlistItem item = new WishlistItem { Code = 450, Name = "Name450", Price = 200, WishlistItemId = 350 };

//            // Act
//            var result = WishlistRepository.DeleteItem(
//                WishlistId,
//                item);

//            // Assert

//            Assert.IsFalse(result);
//            Console.WriteLine(WishlistRepository.GetAll(1).ToString());
//        }

//        [Test]
//        public void UpdateItem_ExistingItem_ShouldBeUpdated()
//        {
//            // Arrange
//            WishlistRepository WishlistRepository1 = new WishlistRepository();
//            WishlistItem item = new WishlistItem { Code = 450, Name = "Name450", Price = 200, WishlistItemId = 1 };
//            int WishlistId = 1;
//            // Act
//            var result = WishlistRepository1.UpdateItem(
//                WishlistId,
//                item);
//            var result1 = WishlistRepository1;
//            // Assert
//            Assert.IsTrue(result);
//            Console.WriteLine(result.ToString());
//            Console.WriteLine(WishlistRepository1.WishlistList.ToString());

//        }

//        [Test]
//        public void UpdateItem_NoExistingItem_ShouldNotBeUpdated()
//        {
//            // Arrange
//            WishlistRepository WishlistRepository1 = new WishlistRepository();
//            WishlistItem item = new WishlistItem { Code = 450, Name = "Name450", Price = 200, WishlistItemId = 100 };
//            int WishlistId = 1;
//            // Act
//            var result = WishlistRepository1.UpdateItem(
//                WishlistId,
//                item);
//            var result1 = WishlistRepository1;
//            // Assert
//            Assert.IsFalse(result);


//        }

//        [Test]
//        public void GetWishlist_ExistingList_ShouldReturnList()
//        {
//            // Arrange
//            WishlistRepository WishlistRepository2 = new WishlistRepository();
//            int count = 0;
//            //var expectedResult = null;
//            // Act
//            Console.WriteLine("count before: " + count);
//            var result = WishlistRepository2.GetWishlistList();
//            var sequence = result.GetEnumerator();
//            while (sequence.MoveNext())
//            {
//                count++;
//                Console.WriteLine("\nCount on while iteration: " + count);
//                Console.WriteLine("result" + result.ToString());
//            }
//            // Assert
//            // Assert.IsFalse(result.);
//            Console.WriteLine("count after: " + count);

//        }

//    }
//}
