using Farfetch.wishlist.Domain.Model;

namespace Farfetch.wishlist.Data.Repository
{
    public interface IOwnerRepository
    {
        void AddOwner(Owner Owner);
        void UpdateOwner( Owner owner);
        Owner GetOwner(int id);
        bool DeleteOwner(Owner owner);

        Wishlist GetWishlist(int id);
       
    }
}