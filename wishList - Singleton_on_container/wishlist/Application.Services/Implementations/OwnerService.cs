using AutoMapper;
using Farfetch.wishlist.Application.DTO;
using Farfetch.wishlist.Application.Services.Interfaces;
using Farfetch.wishlist.Data.Repository;
using Farfetch.wishlist.Domain.Model;


namespace Farfetch.wishlist.Application.Services.Implementations
{
    public class OwnerService : IOwnerService
    {
        IOwnerRepository ownerRepository;
        public OwnerService(IOwnerRepository itemRepository)
        {
            this.ownerRepository = itemRepository;
        }

        public bool AddOwner(DTO.OwnerDTO owner)
        {
            throw new System.NotImplementedException();
        }

        public bool DeleteOwner(DTO.OwnerDTO owner)
        {
            throw new System.NotImplementedException();
        }

        public DTO.OwnerDTO GetOwner(int owner)
        {
            var ownerResult = ownerRepository.GetOwner(owner);
            return Mapper.Map<Owner, DTO.OwnerDTO>(ownerResult);
        }

        public OwnerDTO GetWishlists(int id)
        {
            throw new System.NotImplementedException();
        }

        public bool UpdateOwner(DTO.OwnerDTO owner)
        {
            throw new System.NotImplementedException();
        }

        DTO.OwnerDTO IOwnerService.GetOwner(int owner)
        {
            throw new System.NotImplementedException();
        }

        DTO.OwnerDTO IOwnerService.GetWishlists(int id)
        {
            throw new System.NotImplementedException();
        }
    }
}
