using Farfetch.wishlist.Application.DTO;
using Farfetch.wishlist.Application.Services.Interfaces;
using Farfetch.wishlist.Data.Repository;

namespace Farfetch.wishlist.Application.Services.Implementations
{
    public class OwnerService : IOwnerService
    {
        IOwnerRepository ownerRepository;
        public OwnerService(IOwnerRepository itemRepository)
        {
            this.ownerRepository = itemRepository;
        }

        public bool AddOwner(OwnerDTO owner)
        {
            throw new System.NotImplementedException();
        }

        public bool DeleteOwner(OwnerDTO owner)
        {
            throw new System.NotImplementedException();
        }

        public OwnerDTO GetOwner(OwnerDTO owner)
        {
            throw new System.NotImplementedException();
        }

        public OwnerDTO GetWishlists(int id)
        {
            throw new System.NotImplementedException();
        }

        //public Owner GetOwner(int id)
        //{
        //    var owner = ownerRepository.
        //}

        public bool UpdateOwner(OwnerDTO owner)
        {
            throw new System.NotImplementedException();
        }
    }
}
