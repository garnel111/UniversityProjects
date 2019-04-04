using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Farfetch.wishlist.Domain.Model;

namespace Farfetch.wishlist.Data.Repository
{
    public class OwnerRepository : IOwnerRepository

    {
         Wishlist wishlist ;
        public OwnerRepository()
        {
            
        }
        public bool AddOwner(int id)
        {
            throw new NotImplementedException();
        }

        public bool DeleteOwner(Owner owner)
        {
            throw new NotImplementedException();
        }

        public Owner GetOwner(Owner owner)
        {
            throw new NotImplementedException();
        }

        public Wishlist GetWishlist(int id)
        {
            throw new NotImplementedException();
        }

        public bool UpdateOwner(Owner owner)
        {
            throw new NotImplementedException();
        }
    }
}
