namespace Farfetch.wishlist.Domain.Model
{
    public abstract class AuditableDomainEntity : DomainEntity,  IAuditableEntity
    {
        public AuditableDomainEntity()
        {

        }
        System.DateTime DateCreated;
        System.DateTime DateUpdated;
    }
}