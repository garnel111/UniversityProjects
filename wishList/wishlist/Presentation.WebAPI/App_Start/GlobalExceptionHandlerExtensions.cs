//using Farfetch.Framework.Rest.Common;
//using Farfetch.Framework.Rest.Server.Handlers;
//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Net;
//using System.Web;

//namespace Presentation.WebAPI.App_Start
//{
//    public static class GlobalExceptionHandlerExtensions
//    {
//        public static void MapDomainExceptions(this GlobalExceptionHandler handler)
//        {
//            handler.AddMapping<InvalidDomainArgumentException>(ex =>
//                            new ExceptionMappingResult(
//                                HttpStatusCode.BadRequest,
//                                new ApiError(ex.Message, Farfetch.Framework.Rest.Common.ErrorCodes.ArgumentError, string.Empty)));

//            handler.AddMapping<InvalidDomainEntityException>(ex =>
//                            new ExceptionMappingResult(
//                                HttpStatusCode.BadRequest,
//                                new ApiError((ex as InvalidDomainEntityException).Message, ErrorCodes.InvalidModel, string.Empty, ex)));

//            handler.AddMapping<InvalidDomainValueObjectException>(ex =>
//                                new ExceptionMappingResult(
//                                    HttpStatusCode.BadRequest,
//                                    new ApiError(ex.Message, ErrorCodes.InvalidModel, string.Empty)));

//            handler.AddMapping<InvalidDomainOperationException>(ex =>
//                            new ExceptionMappingResult(
//                                HttpStatusCode.BadRequest,
//                                new ApiError(ex.Message, ErrorCodes.Constraint, string.Empty)));

//            handler.AddMapping<DomainOutOfRangeException>(ex =>
//                                new ExceptionMappingResult(
//                                    HttpStatusCode.BadRequest,
//                                    new ApiError(ex.Message, ErrorCodes.Notfound, string.Empty)));
//        }

//        public static void MapServiceExceptions(this GlobalExceptionHandler handler)
//        {
//            handler.AddMapping<ResourceNotFoundException>(ex =>
//                            new ExceptionMappingResult(
//                                HttpStatusCode.NotFound,
//                                new ApiError(ex.Message, ErrorCodes.Notfound, string.Empty)));

//            handler.AddMapping<ResourceAlreadyExistsException>(ex =>
//                            new ExceptionMappingResult(
//                                HttpStatusCode.Conflict,
//                                new ApiError(ex.Message, ErrorCodes.AlreadyExists, string.Empty)));
//        }
//    }
//}