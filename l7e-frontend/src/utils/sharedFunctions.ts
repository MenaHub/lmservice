export function minPageHeight(offset: number) {
  //console.log('offset: ', offset);
  return { minHeight: offset ? `calc(720px - ${offset}px)` : '720px' };
}
