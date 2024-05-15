/**
 * Generated by orval v6.28.2 🍺
 * Do not edit manually.
 * OpenAPI definition
 * OpenAPI spec version: v0
 */
import type { JsonSchema, RepresentationModelObject } from './model';
import { customInstance } from '../boot/axios';

type SecondParameter<T extends (...args: any) => any> = Parameters<T>[1];

export const listAllFormsOfMetadata1 = (
  options?: SecondParameter<typeof customInstance>
) => {
  return customInstance<RepresentationModelObject>(
    { url: `/profile`, method: 'GET' },
    options
  );
};
export const descriptor111 = (
  options?: SecondParameter<typeof customInstance>
) => {
  return customInstance<string | JsonSchema>(
    { url: `/profile/shopItemEntities`, method: 'GET' },
    options
  );
};
export const descriptor112 = (
  options?: SecondParameter<typeof customInstance>
) => {
  return customInstance<string | JsonSchema>(
    { url: `/profile/userEnquiryEntities`, method: 'GET' },
    options
  );
};
export type ListAllFormsOfMetadata1Result = NonNullable<
  Awaited<ReturnType<typeof listAllFormsOfMetadata1>>
>;
export type Descriptor111Result = NonNullable<
  Awaited<ReturnType<typeof descriptor111>>
>;
export type Descriptor112Result = NonNullable<
  Awaited<ReturnType<typeof descriptor112>>
>;
