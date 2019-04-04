using Farfetch.wishlist.Domain.Core.Interface;
using Farfetch.wishlist.Domain.Model;
using SharpRepository.EfRepository;
using System;
using System.Data.Entity;

namespace Farfetch.wishlist.Data.Repository
{
    public class OwnerRepository : EfRepository<Owner,Guid>, IOwnerRepository

    {
       
        IWishlistRepository WishlistRepository;
        public OwnerRepository(DbContext dbContext) : base(dbContext, null)
        {
        }

        public OwnerRepository(DbContext dbContext, IWishlistRepository WishlistRepository) : base(dbContext, null)
        {
            this.WishlistRepository = WishlistRepository;
        }

        public void AddOwner(Owner owner)
        {
            Add(owner);
        }

        public bool DeleteOwner(Owner owner)
        {
            throw new NotImplementedException();
        }

        public Owner GetOwner(int id)
        {
            return this.Find(ow => ow.ExternalId == id);
           
        }

        public Wishlist GetWishlist(int id)
        {
            throw new NotImplementedException();
        }

        public void UpdateOwner(Owner owner)
        {
            throw new NotImplementedException();
        }
    }
}
