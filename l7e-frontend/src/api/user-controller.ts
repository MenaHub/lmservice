/**
 * Generated by orval v6.28.2 🍺
 * Do not edit manually.
 * OpenAPI definition
 * OpenAPI spec version: v0
 */
import type { BodyBuilder, UserEnquiryBean } from './model';
import { customInstance } from '../boot/axios';

type SecondParameter<T extends (...args: any) => any> = Parameters<T>[1];

export const createUserEnquiry = (
  userEnquiryBean: UserEnquiryBean,
  options?: SecondParameter<typeof customInstance>
) => {
  return customInstance<BodyBuilder>(
    {
      url: `/createUserEnquiry`,
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      data: userEnquiryBean,
    },
    options
  );
};
export type CreateUserEnquiryResult = NonNullable<
  Awaited<ReturnType<typeof createUserEnquiry>>
>;