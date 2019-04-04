using AutoMapper;
using Farfetch.wishlist.Application.DTO;
using Farfetch.wishlist.Domain.Model;

namespace Farfetch.wishlist.Application.Services.TypeAdapters
{
    class WishlistProfile : Profile
    {
        public WishlistProfile()
        {
            CreateMap<Wishlist, WishlistDTO>()
                .ForMember(w => w.ExternalId, o => o.MapFrom(x => x.ExternalId))
                .ForMember(w => w.OwnerId, o => o.MapFrom(x => x.OwnerId))
               // .ForMember(w => w.Items, o => o.MapFrom(x => x.Items))
                .ForAllOtherMembers(p => p.Ignore());

            CreateMap<WishlistDTO, Wishlist>()
             .ForMember(w => w.ExternalId, o => o.MapFrom(x => x.ExternalId))
             .ForMember(w => w.OwnerId, o => o.MapFrom(x => x.OwnerId))
              //.ForMember(w => w.Items, o => o.MapFrom(x => x.Items))
             .ForAllOtherMembers(p => p.Ignore());

            //configurar owner
            CreateMap<Owner, OwnerDTO>()
              .ForMember(w => w.Name, o => o.MapFrom(x => x.Name))
              .ForMember(w => w.ExternalId, o => o.MapFrom(x => x.ExternalId))
              .ForAllOtherMembers(p => p.Ignore());

            //configurar owner
            CreateMap<OwnerDTO, Owner>()
              .ForMember(w => w.Name, o => o.MapFrom(x => x.Name))
              .ForMember(w => w.ExternalId, o => o.MapFrom(x => x.ExternalId))
              .ForAllOtherMembers(p => p.Ignore());

        }
    }
}
